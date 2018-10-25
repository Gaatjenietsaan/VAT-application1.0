package com.proftaak.VAT;

import Dbconnection.ConnectionClass;
import com.proftaak.VAT.datamodel.Cylinder;
import com.proftaak.VAT.datamodel.DoubleSpinnerFactory;
import com.proftaak.VAT.datamodel.Shape;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class CilinderController {

    @FXML
    public Spinner<Double> cilinderStraal;
    @FXML
    public Spinner<Double> cilinderHoogte;
    @FXML
    private Button clearButton;
    @FXML
    private Button saveCilinderButton;

    private Cylinder cylinder = new Cylinder();
    private Connection connection;

    public void initialize() {
        connection = ConnectionClass.connect();
        cilinderStraal.setValueFactory(new DoubleSpinnerFactory());
        cilinderStraal.getValueFactory().valueProperty().bindBidirectional(cylinder.getRadiusProperty());

        cilinderHoogte.setValueFactory(new DoubleSpinnerFactory());
        cilinderHoogte.getValueFactory().valueProperty().bindBidirectional(cylinder.getHeightProperty());
    }

    public void processResults(){

    }

    public void onClearButtonClicked(ActionEvent event) {
        cilinderHoogte.getValueFactory().valueProperty().setValue(0.0);
        cilinderStraal.getValueFactory().valueProperty().setValue(0.0);
    }

    public void onSaveCilinder(ActionEvent event) {
        try {
            cylinder.insert(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
