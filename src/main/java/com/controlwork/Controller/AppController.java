package com.controlwork.Controller;

import com.controlwork.App;
import com.controlwork.Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private ObservableList<Country> countryData = FXCollections.observableArrayList();
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
        capital.setCellValueFactory(new PropertyValueFactory<>("capitalName"));
        area.setCellValueFactory(new PropertyValueFactory<>("area"));
        population.setCellValueFactory(new PropertyValueFactory<>("population"));
        continent.setCellValueFactory(new PropertyValueFactory<>("continent"));
        countryData.sort(countryComparator);
        countries.setItems(countryData);
        showDetailsCountry(null);
        countries.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsCountry(newValue));

    }

    private  void showDetailsCountry(Country country) {
        if (country != null) {
            continentLabel.setText(country.getContinent());
            countryLabel.setText(country.getCountryName());
            capitalLabel.setText(country.getCapitalName());
            areLabel.setText(String.valueOf(country.getArea()));
            populationLabel.setText(String.valueOf(country.getPopulation()));
        }
         else {
             continentLabel.setText("");
             countryLabel.setText("");
             capitalLabel.setText("");
             areLabel.setText("");
             populationLabel.setText("");
        }

    }


}