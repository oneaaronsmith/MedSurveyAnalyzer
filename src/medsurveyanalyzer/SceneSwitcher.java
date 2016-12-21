/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author Aaron
 */
public abstract class SceneSwitcher {
    //This class is based off of the in class example for switching FXML Scenes
    
    //Set up variables needed for each SceneSwitcher.
    public static Scene scene;
    protected Parent root;
    
    //A hashmap for storing the String, sceneSwitcher relationships
    public static HashMap<String,SceneSwitcher> fxmlcontrollers = new HashMap<>();
    
    //Function for returning the root of the SceneSwitcher that calls it
    public Parent getTheRoot() {
        return root;
    }
    
    //Function for assigning a new root
    public void chooseTheRoot(Parent root) {
        this.root = root;
    }
    
    //This function adds a controller to the fxmlcontrollers hashmap.
    public static SceneSwitcher add(String controllerName) {
        
        //Make a SceneSwitcher variable
        SceneSwitcher fxmlController;
        
        //Try to retrieve the fxmlController from HashMap if the name desired is already taken.
        fxmlController = fxmlcontrollers.get(controllerName);
        
        //Check if the fxml name existed. If not, create a new one.
        if(fxmlController == null) {
            try {
                //Load
                FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(controllerName + ".fxml"));
                System.out.println(controllerName + ".fxml");
                Parent root = (Parent)loader.load();
                fxmlController = (SceneSwitcher)loader.getController();
                fxmlController.chooseTheRoot(root);
                fxmlcontrollers.put(controllerName, fxmlController);
            } catch (Exception e) {
                System.out.println("Error. Could not load the fxml file");
                fxmlController = null;
            }
        }
        
        return fxmlController;
    }
    
    public static void switchController(String controllerName) {
        //This function is changes the scene.
        
        SceneSwitcher fxmlController = fxmlcontrollers.get(controllerName);
        
        if(fxmlController == null) {
            add(controllerName);
        }
        else {
            if(scene != null)
                scene.setRoot(fxmlController.getTheRoot());
        }
        
    }

    public static SceneSwitcher getController(String controllerName){
        return fxmlcontrollers.get(controllerName);  
    }
    
    public static void about() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("All About Medzou Survey Analyzer, an Analysis Tool for Studying Patient Care");
        alert.setContentText("My name is Aaron Smith and I am double major in computer science and biochemistry. "
                + "This application implements SQLite with a database file of patient survey data from Medzou. "
                + "The Medzou Community Health Clinic is a student run non-profit "
                + "organization that aims to provide medical care to the uninsured population of Columbia, Missouri.  "
                + "Over the past decade, the clinic has afforded thousands of free appointments to individuals of lower "
                + "socioeconomic status which include an opportunity to meet with a healthcare provider face-to-face.  "
                + "As the organization has matured, it has sought to meet the demand for quality primary care beyond the level of "
                + "an 'urgent care' experience for the patient population which it serves.  To better address this challenge, "
                + "a group of medical students began a quality improvement initiative that involved reviewing all of the patient charts "
                + "at the clinic to identify areas of weakness to be improved upon in the year to come.  "
                + "By evaluating how the clinic managed common disease states such as hypertension, diabetes, asthma, and mental illness, "
                + "the researchers hoped to discover areas in which quantifiable changes could be implemented at the start of the 2017 calendar year.  "
                + "The result of this initiative led to the formation of a terribly cumbersome spreadsheet that was beyond the skill-set of the medical "
                + "team to properly analyze.  Due to my background in both biochemistry and computer science, I was approached by a member of the "
                + "research initiative to design a program that would assist in the organization and analysis of the data.  "
                + "This app loads information from a database to provide information about patients. "
                + "It allows users to choose what sort of survey information they want to view and save it to a text file. "
                + "It is my hope that the program I have designed for this project will help facilitate meaningful changes to improve patient-care at MedZou "
                + "and that it would ultimately result in benefitting the uninsured people of this city.");
        
        alert.showAndWait();
    }
}