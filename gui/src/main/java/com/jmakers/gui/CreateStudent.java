package com.jmakers.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreateStudent {
	static Student open() {
        Stage newStage = new Stage();
        newStage.setTitle("New Window");

        // Set up the scene for the new stage
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 200, 150);
        newStage.setScene(scene);

        // Show the new stage
        newStage.show();
        return null;
	}
}
