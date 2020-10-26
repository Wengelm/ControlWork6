import Model.Country;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    private ObservableList<Country> countryData = FXCollections.observableArrayList();

    public App() {
        // В качестве образца добавляем некоторые данные
        countryData.add(new Country("Hans", "Muster", 12,123 , "asd"));
        countryData.add(new Country("Hans", "Muster", 12,123 , "asd"));

    }

    public ObservableList<Country> getCountryData() {
        return countryData;
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass()
                    .getResource("/app.fxml"));

            primaryStage.setTitle("Client");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);


    } }