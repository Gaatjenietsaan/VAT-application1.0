package com.proftaak.VAT.Calculatiemodel;

public class CalculatorCilinder {
    public static int height;
    public static int radius;

    public Cilinder(int height, int radius) {
        this.height = height;
        this.radius = radius;
    }

    public static double getSurfaceArea() {
        int radiusSquared = radius * radius;
        double surfaceArea = 2 * Math.PI * radius * height + 2 * Math.PI * radiusSquared;
        return surfaceArea;
    }

    public static double getVolume() {
        int radiusSquared = radius * radius;
        double volume = Math.PI * radiusSquared * height;
        return volume;
    }
}
