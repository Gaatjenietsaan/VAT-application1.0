package com.proftaak.VAT.datamodel;

        import org.junit.Test;

        import static org.junit.Assert.*;

public class CylinderTest {

    @Test
    public void getVolume() {

        Cylinder cylinder = new Cylinder();

        System.out.println("test case cylinder");
        assertEquals("cylinder test fails",cylinder.getVolume());

        //(Math.PI * (this.radiusProperty.getValue() * 2)) * this.getHeightProperty().getValue();


    }
}