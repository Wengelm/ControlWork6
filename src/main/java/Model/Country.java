package Model;

public class Country implements Comparable<Country>{

    private String countryName;
    private String capitalName;
    private int area;
    private int population;
    private String continent;


    public Country(String countryName, String capitalName, int area, int population, String continent) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.area = area;
        this.population = population;
        this.continent = continent;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public int compareTo(Country c) {
        return this.countryName.compareTo(c.countryName);
    }
}
