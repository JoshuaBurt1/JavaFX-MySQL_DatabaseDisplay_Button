package com.example.joshuaburt_comp1011sec005_labex05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

//Version 1 of SQL Query table search:
//~does not require fx:controller in .fxml file
//~does not require onMouseClicked in .fxml file
//~build in a single file (but not MVC architecture)
public class Lab5V1 extends Application {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField search;
    @FXML
    private Button searchCity;
    @FXML
    private Button showAll;
    @FXML
    private Button clear;
    private Connection connection;
    private PreparedStatement statement;
    int nLength = 15;
    int aLength = 40;

    @Override
    public void start(Stage stage) { //allows user to search on initialization
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Lab5V1.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 270);
            stage.setTitle("Institution Search");

            textArea = (TextArea) fxmlLoader.getNamespace().get("textArea");
            search = (TextField) fxmlLoader.getNamespace().get("search");
            searchCity = (Button) fxmlLoader.getNamespace().get("searchButton");
            showAll = (Button) fxmlLoader.getNamespace().get("showAll");
            clear = (Button) fxmlLoader.getNamespace().get("clear");

            final String DATABASE_URL = "jdbc:mysql://localhost:3308/institution";
            String USERNAME = "root";
            String PASSWORD = "";
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            searchCity.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    searchCity();
                }
            });
            showAll.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    showAll();
                }
            });
            clear.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    clear();
                }
            });

            stage.setTitle("Student Search by City");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchCity() { //searches city from textfield
        String city = search.getText();

        try {
            final String SELECT_QUERY = "SELECT * FROM Student WHERE city = ?";
            statement = connection.prepareStatement(SELECT_QUERY);
            statement.setString(1, city);
            ResultSet resultSet = statement.executeQuery();
            textArea.clear(); //clears previous query results

            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String province = resultSet.getString("province");
                String postalCode = resultSet.getString("postalCode");

                String studentInfo =  studentID + "\t" + formatString(firstName, nLength) + "\t" + formatString(lastName, nLength) + "\t" + formatString(address,aLength) + "\t" + formatString(city,nLength) + "\t"+ province + "\t" + postalCode + "\n";

                textArea.appendText(studentInfo);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showAll() { //shows all data in TextArea
        try {
            final String SELECT_QUERY = "SELECT * FROM Student";
            statement = connection.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = statement.executeQuery();
            textArea.clear(); //clears previous query results

            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String postalCode = resultSet.getString("postalCode");

                String studentInfo =  studentID + "\t" + formatString(firstName, nLength) + "\t" + formatString(lastName, nLength) + "\t" + formatString(address,aLength) + "\t" + formatString(city,nLength) + "\t"+ province + "\t" + postalCode + "\n";

                textArea.appendText(studentInfo);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void clear() { //clears TextArea
        textArea.clear();
    }

    public static String formatString(String data, int dataLength) { //adds blankspace up to desired length in order to format data into columns
        if (data.length() >= dataLength) {
            return data;
        } else {
            StringBuilder newLength = new StringBuilder(data);
            while (newLength.length() < dataLength) {
                newLength.append(" ");
            }
            //System.out.println(sb.length());
            return newLength.toString();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}