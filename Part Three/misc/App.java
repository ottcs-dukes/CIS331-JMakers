package com.mycompany.inventoryui;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.pool.*;
import oracle.jdbc.*;
import java.util.*;
import javafx.geometry.Pos;

/**
 * JavaFX App
 */
public class App extends Application {

    // Class Data Field Level Variables
    public static OracleDataSource oDS;
    public static Connection jsqlConn;
    public static PreparedStatement jsqlStmt;
    public static ResultSet jsqlResults;
    public static Scanner keyboardIn = new Scanner(System.in);
    
    Label lblItemName = new Label("Name:");
    TextField txtItemName = new TextField();
    
    Label lblItemDesc = new Label("Description:");
    TextField txtItemDesc = new TextField();
    
    Label lblItemCost = new Label("Cost:");
    TextField txtItemCost = new TextField();
    
    Label lblItemQty = new Label("Quantity:");
    TextField txtItemQty = new TextField();
    
    Button btnAddItem = new Button("Add New Item ->");
    
    TextArea txtaInventoryList = new TextArea();
    
    ArrayList<InventoryItem> list = new ArrayList<>();
    ComboBox<InventoryItem> cmboInventory = new ComboBox<>();
    
    Label lblOutput = new Label();
    
    @Override
    public void start(Stage stage) {
        GridPane primaryPane = new GridPane();
        
        primaryPane.setAlignment(Pos.CENTER);
        
        primaryPane.add(lblItemName, 0, 0);
        primaryPane.add(txtItemName, 1, 0);
        primaryPane.add(lblItemDesc, 0, 1);
        primaryPane.add(txtItemDesc, 1, 1);
        primaryPane.add(lblItemCost, 0, 2);
        primaryPane.add(txtItemCost, 1, 2);
        primaryPane.add(lblItemQty, 0, 3);
        primaryPane.add(txtItemQty, 1, 3);
        primaryPane.add(btnAddItem, 0, 4);
        primaryPane.add(lblOutput, 0, 5, 2, 1);
        primaryPane.add(cmboInventory, 2, 0);
        primaryPane.add(txtaInventoryList, 2, 1, 1, 4);
        
        Scene primaryScene = new Scene(primaryPane, 800, 400);
        
        txtaInventoryList.setMaxWidth(400);
        txtaInventoryList.setMinWidth(400);
        
        // So that the format specifiers work in FX Controls:
        txtaInventoryList.setStyle("-fx-font-family: monospace");
        cmboInventory.setStyle("-fx-font-family: monospace");
        
        stage.setScene(primaryScene);
        stage.setTitle("Inventory UI");
        stage.show();
        
        btnAddItem.setOnAction(e -> {
            String name, desc;
            double cost;
            int qty;
            
            name = txtItemName.getText();
            desc = txtItemDesc.getText();
            cost = Double.valueOf(txtItemCost.getText());
            qty = Integer.valueOf(txtItemQty.getText());
            
            // Instantiate an InventoryItem
            InventoryItem temp = new InventoryItem(name, desc, cost, qty);
            
            // Add instance object to ArrayList
            list.add(temp);
            
            // Add item to DB:
            String sqlQuery = "INSERT INTO INVENTORY "
                    + "(ITEMNAME,ITEMDESCRIPTION,ITEMCOST,ITEMQTY) "
                    + "VALUES "
                    + "('" + name + "','" + desc + "'," + cost + "," + qty + ")";
            
            runDBQuery(sqlQuery, 'c');
            
            // Refresh the Inventory List TextArea
            refreshInventoryDisplay();
        });
        
        cmboInventory.setOnAction(e -> {
            // When an item in the ComboBox is selected...
            lblOutput.setText("Index of selected object is: "
                + cmboInventory.getSelectionModel().getSelectedIndex()
                + " and its .toString() is: "
                + cmboInventory.getSelectionModel().getSelectedItem().toString());
        });
        
        // Last Task on Startup: Load Data from DB
        loadData();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void loadData() {
        String sqlQuery = "SELECT * FROM INVENTORY";
        
        String name, desc;
        double cost;
        int qty;
        
        try {
            runDBQuery(sqlQuery, 'r');
            while (jsqlResults.next()) {
                // Load this row's data, if any:
                name = jsqlResults.getString(1);
                desc = jsqlResults.getString(2);
                cost = jsqlResults.getDouble(3);
                qty = jsqlResults.getInt(4);
                
                list.add(new InventoryItem(name, desc, cost, qty));
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex.toString());
        }
    }
    
    public void refreshInventoryDisplay() {
        // Clear the TextArea
        txtaInventoryList.clear();
        
        // Clear out the ObservableList for the ComboBox
        cmboInventory.getItems().clear();
        
        for (InventoryItem item : list) {
            // Add the text of the item to the TextArea
            txtaInventoryList.appendText(item.toString() + "\n");
            
            // Copy the reference to the instance object into the ComboBox
            cmboInventory.getItems().add(item);
        }
    }
    
    public static void runDBQuery(String query, char queryType) {
        // queryType - Using the C.R.U.D. acronym
        // 'r' - SELECT
        // 'c', 'u', or 'd' - UPDATE, INSERT, DELETE
        
        try {
            String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String user = "javauser";
            String pass = "javapass";
            
            oDS = new OracleDataSource();
            oDS.setURL(URL);
            
            jsqlConn = oDS.getConnection(user, pass);
            jsqlStmt = jsqlConn.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            
            if (queryType == 'r')
                jsqlResults = jsqlStmt.executeQuery();
            else
                jsqlStmt.executeUpdate();
        } catch (SQLException sqlex) {
            System.out.println(sqlex.toString());
        }
    }
}