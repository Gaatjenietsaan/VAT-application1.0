package com.proftaak.VAT;

import com.proftaak.VAT.datamodel.VatData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

        VatData.getInstance().addVormItems(new VormItems(cilinderStraal, cilinderHoogte));
    }
}
