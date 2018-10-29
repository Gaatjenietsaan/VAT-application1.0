package com.proftaak.VAT.datamodel;

import javafx.scene.control.SpinnerValueFactory;

public class DoubleSpinnerFactory extends SpinnerValueFactory<Double> {
    @Override
    public void decrement(int steps) {
        this.valueProperty().setValue(this.valueProperty().getValue() - steps);
    }

    @Override
    public void increment(int steps) {
        this.valueProperty().setValue(this.valueProperty().getValue() + steps);
    }
}
