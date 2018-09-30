package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    @FXML
    TextField tfText;

    @FXML
    ComboBox cbNames;

    private final StringProperty twoWayInput = new SimpleStringProperty("");

    final ObservableList<String> listA = FXCollections.observableArrayList("Apple", "Apricot", "Avacado");

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        twoWayInput.set("SetValue");
        listA.clear();
        listA.setAll("Butter", "Banana", "Bacon");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tfText.textProperty().bindBidirectional(twoWayInputProperty());
        cbNames.setItems(listA);
    }

    public String getTwoWayInput()
    {
        return twoWayInput.get();
    }

    public StringProperty twoWayInputProperty()
    {
        return twoWayInput;
    }

    public void setTwoWayInput(String twoWayInput)
    {
        this.twoWayInput.set(twoWayInput);
    }
}
