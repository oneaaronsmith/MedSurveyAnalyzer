/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Aaron
 */
public class MedSurveyAnalyzer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Load the parent root and then add fxml files to the SceneSwitcher Hashmap (see SceneSwitcher.java)
        Parent root = FXMLLoader.load(getClass().getResource("MedSurveyFXMLDocument.fxml"));
        SceneSwitcher.add("MedSurveyFXMLDocument");
        SceneSwitcher.add("MedSurveyAnalysisPageFXMLDocument");
        
        //Make a new scene
        Scene scene = new Scene(root);
        SceneSwitcher.scene = scene;
        SceneSwitcher.switchController("MedSurveyFXMLDocument");
        
        //Set the scene with an icon and title. Then show the stage.
        stage.setScene(scene);
        Image icon = new Image(getClass().getResourceAsStream("medicine_favicon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Medzou Survey Analyzer");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
