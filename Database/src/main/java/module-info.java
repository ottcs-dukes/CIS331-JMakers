module com.mycompany.database {
    requires javafx.controls;
    exports com.mycompany.database;
    
    requires java.sql;
    requires com.oracle.database.jdbc;
    requires java.naming;
}
