package application;

import application.MainApp;
import application.controllers.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StageModel {

    private Controller controller;
    private Pane rootLayout;
    private Stage primaryStage;
    private String pathToFXML;
    private Object dataToController;
    private MainApp mainApp;

    public StageModel(Stage primaryStage, String pathToFXML) {
        this.primaryStage = primaryStage;
        this.pathToFXML = pathToFXML;
    }

    public void setDataToController(Object dataToController) {
        this.dataToController = dataToController;
    }
    @FXML
    public void initialize(){
        init();
    }

    public void init(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(pathToFXML));
            rootLayout =  loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Даём контроллеру доступ к главному прилодению.
            controller = loader.getController();
            controller.setInputData(dataToController);
            controller.setMainApp(mainApp);
           controller.updateElementsData();

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public Pane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void show(){
        primaryStage.show();
    }
    public void close(){
        primaryStage.close();
    }


}
