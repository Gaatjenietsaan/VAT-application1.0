package com.proftaak.VAT.datamodel;

public class ItemsVat {

    private String shortDescription;
    private String details;

    public ItemsVat(String shortDescription, String details){
        this.shortDescription = shortDescription;
        this.details = details;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}
