package com.controlwork.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Country {

    private StringProperty countryName;
    private StringProperty capitalName;
    private IntegerProperty area;
    private IntegerProperty population;
    private StringProperty continent;

    public Country(String countryName, String capitalName, Integer area, Integer population, String continent) {
        this.countryName = new SimpleStringProperty(countryName);
        this.capitalName = new SimpleStringProperty(capitalName);
        this.area = new SimpleIntegerProperty(area);
        this.population = new SimpleIntegerProperty(population);
        this.continent = new SimpleStringProperty(continent);
    }

    public Country() {

    }

    public String getCountryName() {
        return countryName.get();
    }

    public StringProperty countryNameProperty() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName.set(countryName);
    }

    public String getCapitalName() {
        return capitalName.get();
    }

    public StringProperty capitalNameProperty() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName.set(capitalName);
    }

    public int getArea() {
        return area.get();
    }

    public IntegerProperty areaProperty() {
        return area;
    }

    public void setArea(int area) {
        this.area.set(area);
    }

    public int getPopulation() {
        return population.get();
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public void setPopulation(int population) {
        this.population.set(population);
    }

    public String getContinent() {
        return continent.get();
    }

    public StringProperty continentProperty() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent.set(continent);
    }
}
