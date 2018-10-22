package com.proftaak.VAT.datamodel;

import java.util.List;

public class VatData {
    private static VatData instance = new VatData();
    private static String filename = "VatListItems.txt";

    private List<ItemsVat> vormitems;

    public static VatData getInstance(){

        return instance;
    }

    public List<ItemsVat>getVormitems(){

        this.vormitems = vormitems;
    }
}
