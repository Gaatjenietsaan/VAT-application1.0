package com.proftaak.VAT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private Button cilinderButton1;
    @FXML
    private Button bolButton1;
    @FXML
    private Button blokButton1;

    public void  onButtonClicked(ActionEvent e){
        if (e.getSource().equals(cilinderButton1)){
            System.out.println("Saved ");
        } else if (e.getSource().equals(bolButton1)){
            System.out.println("Saved ");
        } else if (e.getSource().equals(blokButton1)){
            System.out.println("Saved ");
        }
    }
}
