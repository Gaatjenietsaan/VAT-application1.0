package com.proftaak.VAT.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class VatData {
    private static VatData instance = new VatData();
    private static String filename = "VatListItems.txt";
    private List<ItemsVat> VormItems;



    public static VatData getInstance(){
        return instance;
    }

    public List<ItemsVat> getVormItems(){
        return this.VormItems;
    }

    public void addVormItems(ItemsVat item) {
        VormItems.add(item);
    }

    public void loadVormItems() throws IOException{
        VormItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while ((input = br.readLine()) != null){
                String[] itemPieces = input.split("\t");

                String ShortDescription = itemPieces[0];
                String details = itemPieces[1];

                ItemsVat VormItem = new ItemsVat(ShortDescription, details);
                VormItems.add(VormItem);
            }
        } finally {
            if (br != null){
                br.close();
            }
        }
    }

    public void storeVormItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<ItemsVat> iter = VormItems.iterator();
            while (iter.hasNext()) {
                ItemsVat item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails()));
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}
