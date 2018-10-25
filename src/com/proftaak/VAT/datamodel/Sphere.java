package com.proftaak.VAT.datamodel;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Sphere extends Shape {
    private Property<Double> radiusProperty = new SimpleObjectProperty<Double>(0.0);

    protected static Shape from(ResultSet resultSet) throws SQLException {
        Sphere sphere = new Sphere();
        sphere.radiusProperty.setValue(resultSet.getDouble("straal"));
        return sphere;
    }

    @Override
    HashMap<String, Object> getProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "'Sphere'");
        map.put("straal", this.getRadiusProperty().getValue());
        return map;
    }

    @Override
    double getVolume() {
        return Math.PI * this.radiusProperty.getValue();
    }

    @Override
    public String getDetails() {
        return String.format("radius = %s\nvolume = %s", this.getRadiusProperty().getValue(), this.getVolume());
    }

    public Property<Double> getRadiusProperty() {
        return this.radiusProperty;
    }

    @Override
    public String toString() {
        return "Bol";
    }
}
