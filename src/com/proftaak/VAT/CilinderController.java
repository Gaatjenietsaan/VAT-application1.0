package com.proftaak.VAT;

import Dbconnection.ConnectionClass;
import com.proftaak.VAT.datamodel.Cylinder;
import com.proftaak.VAT.datamodel.DoubleSpinnerFactory;
import com.proftaak.VAT.datamodel.Shape;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class CilinderController {

    @FXML
    public Spinner<Double> cilinderStraal;
    @FXML
    public Spinner<Double> cilinderHoogte;

    private Cylinder cylinder = new Cylinder();

    private Connection connection;

    public void initialize() {
        connection = ConnectionClass.connect();
        cilinderStraal.setValueFactory(new DoubleSpinnerFactory());
        cilinderStraal.getValueFactory().valueProperty().bindBidirectional(cylinder.getRadiusProperty());

        cilinderHoogte.setValueFactory(new DoubleSpinnerFactory());
        cilinderHoogte.getValueFactory().valueProperty().bindBidirectional(cylinder.getHeightProperty());
    }

    public void onClearButtonClicked(ActionEvent event) {
        cilinderHoogte.getValueFactory().valueProperty().setValue(0.0);
        cilinderStraal.getValueFactory().valueProperty().setValue(0.0);
    }

    public void onSaveCilinder(ActionEvent event) {
        try {
            cylinder.insert(connection);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Excelsior", ButtonType.OK);
            alert.setHeaderText("Message");
            alert.setTitle("Cylinder");
            alert.showAndWait();
        } catch (SQLException exception) {
            exception.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Oops", ButtonType.OK);
            alert.setHeaderText("Error!");
            alert.setTitle("Cylinder");
            alert.showAndWait();
        }
    }
}
