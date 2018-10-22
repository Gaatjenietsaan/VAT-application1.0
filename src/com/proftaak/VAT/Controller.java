package com.proftaak.VAT;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private List<ItemsVat> vormItems;

    @FXML
    private Button cilinderButton1;
    @FXML
    private Button bolButton1;
    @FXML
    private Button blokButton1;
    @FXML
    private Button clearButton;
    @FXML
    private ListView<ItemsVat> savedVormsListView;
    @FXML
    private TextArea savedVormInfo;

    public void initialize(){
        vormItems = new ArrayList<ItemsVat>();



        savedVormsListView.getItems().setAll(vormItems);
        savedVormsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        savedVormsListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        ItemsVat item = (ItemsVat) savedVormsListView.getSelectionModel().getSelectedItem();
        savedVormInfo.setText(item.getDetails());

    }

    public void onButtonClicked (ActionEvent event) throws Exception{
        if (event.getSource()==cilinderButton1){
            this.openNew("Windowcilinder.fxml", "Cilinder: ");
        } else if (event.getSource()==bolButton1) {
            this.openNew("Windowbol.fxml", "Bol: ");
        } else if (event.getSource()==blokButton1) {
            this.openNew("Windowblok.fxml", "Blok: ");
        }
    }

    public void openNew(String resource, String title) throws IOException {
        Parent window = FXMLLoader.load(getClass().getResource(resource));
        Scene scene = new Scene(window, 300, 300);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
