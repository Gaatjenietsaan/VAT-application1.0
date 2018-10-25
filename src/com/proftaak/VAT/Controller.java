package com.proftaak.VAT;

import com.proftaak.VAT.datamodel.ItemsVat;
import com.proftaak.VAT.datamodel.VatData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class Controller {

    @FXML
    private Button cilinderButton1;
    @FXML
    private Button bolButton1;
    @FXML
    private Button blokButton1;
    @FXML
    private ListView<ItemsVat> savedVormListView;
    @FXML
    private TextArea savedVormInfo;


    public void initialize(){
        savedVormListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemsVat>() {
            @Override
            public void changed(ObservableValue<? extends ItemsVat> observable, ItemsVat oldValue, ItemsVat newValue) {
                if (newValue != null) {
                    ItemsVat item = savedVormListView.getSelectionModel().getSelectedItem();
                    savedVormInfo.setText(item.getDetails());
                }
            }
        });

        savedVormListView.getItems().setAll(VatData.getInstance().getVormItems());
        savedVormListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        savedVormListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        ItemsVat item = savedVormListView.getSelectionModel().getSelectedItem();
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
