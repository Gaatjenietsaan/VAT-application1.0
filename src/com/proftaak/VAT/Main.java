package com.proftaak.VAT;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Mainwindow.fxml"));
        primaryStage.setTitle("VAT Application");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

        //Scene voor Cilinder
        Parent root1 = FXMLLoader.load(getClass().getResource("Windowcilinder.fxml"));
        primaryStage.setTitle("Cilinder");
        primaryStage.setScene(new Scene(root1,300,300));
        primaryStage.show();

    }
}

