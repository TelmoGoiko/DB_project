package ehu.eus.db_project.ui;

import ehu.eus.db_project.businessLogic.BlFacade;
import ehu.eus.db_project.businessLogic.BlFacadeImplementation;
import ehu.eus.db_project.configuration.Config;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

public class HelloApplication {

    public static void main(String[] args) {

        Config config = Config.getInstance();

        Locale.setDefault(new Locale(config.getLocale()));
        System.out.println("Locale: " + Locale.getDefault());

        BlFacade businessLogic;

        try {

            if (config.isBusinessLogicLocal()) {
                businessLogic = new BlFacadeImplementation();

            new MainGUI(businessLogic);
            }
        } catch (Exception e) {
            System.err.println("Error in ApplicationLauncher: " + e);
        }

        // Database credentials
        String url = "jdbc:mysql://dif-mysql.ehu.es:23306/DBI20";
        String username = "DBI20";
        String password = "DBI20";

        try {
            // Register MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Check if connection is successful
            if (conn != null) {
                System.out.println("Connected to the database!");




                // Perform transactions here
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
                while (rs.next()) {
                    System.out.println(rs.getString("fname"));
                }
                // Close connection
                conn.close();
                System.out.println("Connection closed.");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }


    }
}
