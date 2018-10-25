package com.proftaak.VAT;

import Dbconnection.ConnectionClass;
import com.proftaak.VAT.datamodel.Cylinder;
import com.proftaak.VAT.datamodel.DoubleSpinnerFactory;
import com.proftaak.VAT.datamodel.Shape;
import com.proftaak.VAT.datamodel.Sphere;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import java.sql.Connection;
import java.sql.SQLException;

public class BolController {
    public Spinner<Double> sphereRadius;
    private Sphere sphere = new Sphere();
    private Connection connection;

    public void initialize() {
        connection = ConnectionClass.connect();
        sphereRadius.setValueFactory(new DoubleSpinnerFactory());
        sphereRadius.getValueFactory().valueProperty().bindBidirectional(sphere.getRadiusProperty());
    }

    public void onSave(ActionEvent event) {
        try {
            sphere.insert(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void onClear(ActionEvent event) {
        sphereRadius.getValueFactory().valueProperty().setValue(0.0);
    }
}
