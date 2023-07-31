package com.example.joshuaburt_comp1011sec005_labex05;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Lab5ViewControllerV2 implements Initializable {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField search;
    private static Connection connection;
    private PreparedStatement preparedStatement;
    int nLength = 15;
    int aLength = 40;
    private static final String url = "jdbc:mysql://localhost:3308/institution";
    private static final String user = "root";
    private static final String password = "";


    // Method to retrieve and display student information by city
    @FXML
    void searchCity(/*ActionEvent event*/) {
        String city = search.getText().trim();

        try {
            // Set up the database connection
            getConnection();

            // Prepare the SQL query
            String sql = "SELECT * FROM Student WHERE city = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city);

            // Execute the query and retrieve the results
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear the text area before displaying new results
            textArea.clear();

            // Display the results in the text area
            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String province = resultSet.getString("province");
                String postalCode = resultSet.getString("postalCode");

                String studentInfo = studentID + "\t" + formatString(firstName, nLength) + "\t" + formatString(lastName, nLength) + "\t" + formatString(address, aLength) + "\t" + formatString(city, nLength) + "\t" + province + "\t" + postalCode + "\n";
                textArea.appendText(studentInfo);
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void showAll(/*ActionEvent event*/) {
        try {
            getConnection();
            // Prepare the SQL query
            String sql = "SELECT * FROM Student";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query and retrieve the results
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear the text area before displaying new results
            textArea.clear();

            // Display the results in the text area
            while (resultSet.next()) {
                String studentID = resultSet.getString("studentID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String postalCode = resultSet.getString("postalCode");

                String studentInfo = studentID + "\t" + formatString(firstName, nLength) + "\t" + formatString(lastName, nLength) + "\t" + formatString(address, aLength) + "\t" + formatString(city, nLength) + "\t" + province + "\t" + postalCode + "\n";
                textArea.appendText(studentInfo);
            }
            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clear(/*ActionEvent event*/) {
        textArea.clear();
    }

    public static String formatString(String data, int dataLength) {
        if (data.length() >= dataLength) {
            return data;
        } else {
            StringBuilder newLength = new StringBuilder(data);
            while (newLength.length() < dataLength) {
                newLength.append(" "); //adds blankspace up to desired length in order to format data into columns
            }
            //System.out.println(sb.length());
            return newLength.toString();
        }
    }
    public static Connection getConnection() throws SQLException {
        //Connection connection = null;
        try {
            // Open a connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception for handling in the calling code
        }
        return connection;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

