package com.proftaak.VAT.datamodel;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Cylinder extends Shape {

    private Property<Double> radiusProperty = new SimpleObjectProperty<Double>(0.0);
    private Property<Double> heightProperty = new SimpleObjectProperty<Double>(0.0);

    protected static Shape from(ResultSet resultSet) throws SQLException {
        Cylinder cylinder = new Cylinder();
        cylinder.radiusProperty.setValue(resultSet.getDouble("straal"));
        cylinder.heightProperty.setValue(resultSet.getDouble("hoogte"));
        return cylinder;
    }

    @Override
    HashMap<String, Object> getProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "'Cylinder'");
        map.put("straal", this.getRadiusProperty().getValue());
        map.put("hoogte", this.getHeightProperty().getValue());
        return map;
    }

    @Override
    double getVolume() {
        return (Math.PI * (this.radiusProperty.getValue() * 2)) * this.getHeightProperty().getValue();
    }

    @Override
    public String getDetails() {
        return String.format("height = %s\nradius = %s\nvolume = %s",
                this.getHeightProperty().getValue(),
                this.getRadiusProperty().getValue(),
                this.getVolume()
        );
    }

    public Property<Double> getRadiusProperty() {
        return this.radiusProperty;
    }

    public Property<Double> getHeightProperty() {
        return this.heightProperty;
    }

    @Override
    public String toString() {
        return "Cilinder";
    }
}
