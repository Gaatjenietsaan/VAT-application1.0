package com.proftaak.VAT;

import com.proftaak.VAT.datamodel.VatData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


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
    }

    @Override
    public void stop() {
        try{
            VatData.getInstance().storeVormItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() {
        try{
            VatData.getInstance().loadVormItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

