package com.proftaak.VAT;

import Dbconnection.ConnectionClass;
import com.proftaak.VAT.datamodel.Cube;
import com.proftaak.VAT.datamodel.Cylinder;
import com.proftaak.VAT.datamodel.DoubleSpinnerFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;

import java.sql.Connection;
import java.sql.SQLException;

public class BlokController {

    public Spinner<Double> cubeLength;
    public Spinner<Double> cubeWidth;
    public Spinner<Double> cubeHeight;

    private Cube cube = new Cube();
    private Connection connection;

    public void initialize() {
        connection = ConnectionClass.connect();
        cubeLength.setValueFactory(new DoubleSpinnerFactory());
        cubeLength.getValueFactory().valueProperty().bindBidirectional(cube.getLengthProperty());

        cubeWidth.setValueFactory(new DoubleSpinnerFactory());
        cubeWidth.getValueFactory().valueProperty().bindBidirectional(cube.getWidthProperty());

        cubeHeight.setValueFactory(new DoubleSpinnerFactory());
        cubeHeight.getValueFactory().valueProperty().bindBidirectional(cube.getHeightProperty());
    }

    public void onClear(ActionEvent event) {
        cubeLength.getValueFactory().valueProperty().setValue(0.0);
        cubeWidth.getValueFactory().valueProperty().setValue(0.0);
        cubeHeight.getValueFactory().valueProperty().setValue(0.0);
    }

    public void onSave(ActionEvent event) {
        try {
            cube.insert(connection);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Eureka", ButtonType.OK);
            alert.setHeaderText("Message");
            alert.setTitle("Blok");
            alert.showAndWait();
        } catch (SQLException exception) {
            exception.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Oops", ButtonType.OK);
            alert.setHeaderText("Error!");
            alert.setTitle("Blok");
            alert.showAndWait();
        }
    }
}
