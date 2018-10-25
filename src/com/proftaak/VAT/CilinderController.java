package com.proftaak.VAT;

import com.proftaak.VAT.datamodel.ItemsVat;
import com.proftaak.VAT.datamodel.VatData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class CilinderController {

    @FXML
    private Button clearButton;
    @FXML
    private Button saveCilinderButton;
    @FXML
    private TextField cilinderStraalField;
    @FXML
    private TextField cilinderHoogteField;

    public void processResults(){
        String cilinderStraal = cilinderStraalField.getText().trim();
        String cilinderHoogte = cilinderHoogteField.getText().trim();

        VatData.getInstance().addVormItems(new ItemsVat(cilinderStraal, cilinderHoogte));
    }

    public void onClearButtonClicked(ActionEvent event) {
    }

    public void inputHoogteCilinder(InputMethodEvent inputMethodEvent) {
    }

    public void inputStraalCilinder(InputMethodEvent inputMethodEvent) {
    }

    public void onSaveCilinder(ActionEvent event) {
    }
}
