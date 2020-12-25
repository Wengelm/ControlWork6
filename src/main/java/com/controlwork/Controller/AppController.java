package com.controlwork.Controller;

import com.controlwork.App;
import com.controlwork.Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;


public class AppController implements Initializable {

    @FXML
    TableView<Country> countries;
    @FXML
    TableColumn<Country, String> country;
    @FXML
    TableColumn<Country, String> capital;
    @FXML
    TableColumn<Country, String> continent;
    @FXML
    TableColumn<Country, Integer> area;
    @FXML
    TableColumn<Country, Integer> population;
    @FXML
    ChoiceBox continentChoise;
    @FXML
    Label continentLabel;
    @FXML
    Label countryLabel;
    @FXML
    Label capitalLabel;
    @FXML
    Label areLabel;
    @FXML
    Label populationLabel;
    @FXML
    TextField countryTX;
    @FXML
    TextField capitalTX;
    @FXML
    TextField areaTX;
    @FXML
    TextField populationTX;
    @FXML
    TextField filter;


    private ObservableList<Country> countryData = FXCollections.observableArrayList();
    private FilteredList<Country> filteredData;
    private Comparator<Country> countryComparator = Comparator.comparing(Country::getContinent);


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        countryData.add(new Country("вавыа", "asd", 24, 254, "Евразия"));
        countryData.add(new Country("выавыа", "asd", 24, 254, "Северная Америка"));
        countryData.add(new Country("выаыва", "asd", 24, 254, "Южная Америка"));
        countryData.add(new Country("ываыва", "asd", 24, 254, "Африка"));
        countryData.add(new Country("выаыва", "asd", 24, 254, "Австралия"));
        countryData.add(new Country("ываыва", "asd", 24, 254, "Антарктида"));
        country.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        country.setCellFactory(TextFieldTableCell.<Country>forTableColumn());
        capital.setCellValueFactory(new PropertyValueFactory<>("capitalName"));
        capital.setCellFactory(TextFieldTableCell.<Country>forTableColumn());
        area.setCellValueFactory(new PropertyValueFactory<>("area"));

        population.setCellValueFactory(new PropertyValueFactory<>("population"));

        continent.setCellValueFactory(new PropertyValueFactory<>("continent"));
        continent.setCellFactory(TextFieldTableCell.<Country>forTableColumn());
        countryData.sort(countryComparator);
        countries.setItems(countryData);
        showDetailsCountry(null);
        countries.setEditable(true);
        countries.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsCountry(newValue));

       filter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                filteredData.clear();
                for (Country c: countryData)
                    if (c.getContinent().contains(filter.getText()))
                        filteredData.add(c);

                countries.setItems(filteredData);
            }
        });


    }


    private void showDetailsCountry(Country country) {
        if (country != null) {
            continentLabel.setText(country.getContinent());
            countryLabel.setText(country.getCountryName());
            capitalLabel.setText(country.getCapitalName());
            areLabel.setText(String.valueOf(country.getArea()));
            populationLabel.setText(String.valueOf(country.getPopulation()));
            continentChoise.setValue(country.getContinent());

        } else {
            continentLabel.setText("");
            countryLabel.setText("");
            capitalLabel.setText("");
            areLabel.setText("");
            populationLabel.setText("");
        }

    }

    @FXML
    private void handleDeleteCountry() {
        int selectedIndex = countries.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            countries.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Нет выбора");
            alert.setHeaderText("Не выбрана страна для удаления");
            alert.setContentText("Выберите запись для удаления");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewCotunry() {

        countryData.sort(countryComparator);

        countries.setItems(countryData);


    }


    @FXML
    private void handleEditCountry() {
        Country country = countries.getSelectionModel().getSelectedItem();
        if (country != null) {
            countryData.add(new Country(countryTX.getText(), capitalTX.getText(), Integer.parseInt(areaTX.getText()), Integer.parseInt(populationTX.getText()), (String) continentChoise.getValue()));
            System.out.println(country);
            countryData.add(country);
       }
    }



}