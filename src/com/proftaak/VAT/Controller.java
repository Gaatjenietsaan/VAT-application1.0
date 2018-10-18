package com.proftaak.VAT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private Button cilinderButton1;
    @FXML
    private Button bolButton1;
    @FXML
    private Button blokButton1;

    public void onButtonClicked (ActionEvent event) throws Exception{
        Stage stage;
        Parent root;

        if (event.getSource()==cilinderButton1){
            stage = (Stage)cilinderButton1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Windowcilinder.fxml"));
        }
    }
}
