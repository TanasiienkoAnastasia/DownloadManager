package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("downloadManager.fxml"));
        primaryStage.setTitle("downloadManager");
        primaryStage.setScene(new Scene(root, 892.0, 755.0));
        primaryStage.show();
    }


    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;


        if(user != null){
        launch(args);
         System.out.println("Successful Authentication of: " + user.name);
            System.out.println(" Email: " + user.email);
            System.out.println(" Phone: " + user.phone);
            System.out.println(" Address: " + user.address);
        } else {
            System.out.println("Authentication cancelled");
        }
    }
    }

