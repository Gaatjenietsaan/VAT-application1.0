package com.proftaak.VAT;

import Dbconnection.ConnectionClass;
import com.proftaak.VAT.datamodel.Shape;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
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
import java.sql.Connection;
import java.sql.SQLException;


public class Controller {

    @FXML
    private Button cilinderButton1;
    @FXML
    private Button bolButton1;
    @FXML
    private Button blokButton1;
    @FXML
    private ListView<Shape> savedVormListView;
    @FXML
    private TextArea savedVormInfo;

    private Connection connection;

    private Property<String> shapeDetailsProperty = new SimpleObjectProperty<String>("");

    public void initialize(){
        connection = ConnectionClass.connect();
        savedVormListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        savedVormListView.selectionModelProperty().getValue().selectedItemProperty().addListener(new ChangeListener<Shape>() {
            @Override
            public void changed(ObservableValue<? extends Shape> observable, Shape oldValue, Shape newValue) {
                if (observable.getValue() != null) {
                    shapeDetailsProperty.setValue(observable.getValue().getDetails());
                } else {
                    shapeDetailsProperty.setValue("");
                }
            }
        });
        savedVormInfo.textProperty().bindBidirectional(shapeDetailsProperty);
        refresh();
    }

    private void refresh() {
        try {
            savedVormListView.getItems().clear();
            savedVormListView.getItems().setAll(Shape.getItems(connection));
            savedVormListView.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

        //stage.setOnCloseRequest(event -> {});

         //stage.focusedProperty().addListener((ov, onHidden, onShown) -> {
         //    if (!stage.isFocused())
         //        Platform.runLater(() -> stage.isFocused());
         //});
    }

    public void onRefreshClicked(ActionEvent event) {
        refresh();
    }
}
