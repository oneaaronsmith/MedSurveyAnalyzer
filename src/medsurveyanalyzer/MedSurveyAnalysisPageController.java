/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import static medsurveyanalyzer.SceneSwitcher.switchController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Aaron
 */

public class MedSurveyAnalysisPageController extends SceneSwitcher implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea report;
   
    @FXML
    private TextField sqlsearch;
    
    @FXML
    private void handleButtonGoHome(ActionEvent event) {
        //Returns to homepage scene
        switchController("MedSurveyFXMLDocument");
    }
    
    @FXML
    private void handleButtonShowFullTable(ActionEvent event) {
            //This function shows the entire Raw data table I was given
            //It is painful to look at.
            int i;
            DatabaseManager manage = new DatabaseManager();
            ArrayList<String> table = new ArrayList<>();
            table = manage.selectWholeTable();
            String reporttext = "";
            
            for (i = 0; i < table.size() ; i++) {
                reporttext += (table.get(i) + "\n"); 
            }
            
            report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowRaceInfo(ActionEvent event) {
        //Reports race information
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed who identified their race,\n" +
                " " + request.getNumCaucasions() + " were caucasian.\n" +
                " " + request.getNumAfricanAmericans() + " were African Americans.\n" +
                " " + request.getNumOtherRaces() + " marked other.\n";
        
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowQuestionsAsked(ActionEvent event) {
        //Reports what questions were asked.
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" +
                " " + request.getAllergyQuestionedCount() + " were questioned about their allergies.\n" +
                " " + request.getTobaccoQuestionedCount() + " were questioned about tobacco use.\n" +
                " " + request.getAlcoholQuestionedCount() + " were questioned about alcohol consumption.\n" +
                " " + request.getDrugQuestionedCount() + " were questioned about illegal drug use.\n";
        
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowHypertension(ActionEvent event) {
        //Reports patients with hypertension and whether staff addressed it.
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" +
                " " + request.getHypertensionCount() + " patients had hypertension.\n" +
                " " + request.hypertensionAddressed() + " of the cases were addressed appropriately.\n";
        
        report.setText(reporttext);
        
    }
    
    @FXML
    private void handleButtonShowMentalHealth(ActionEvent event) {
        //Reports patients with mental health and whether staff addressed it.
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" + 
                " " + request.getMentalHealthCount() + " patients had mental health disorders.\n" +
                " " + request.mentalHealthAddressed() + " of the cases were addressed appropriately.\n";
        
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowDiabetes(ActionEvent event) {
        //Reports patients with diabetes and whether staff addressed it.
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" +
                " " + request.getDiabetesCount() + " patients had diabetes.\n" +
                " " + request.diabetesAddressed() + " of the cases were addressed appropriately.\n";
        
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowAsthma(ActionEvent event) {
        //Reports patients with asthma and whether staff addressed it.
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" +
                " " + request.getAsthmaCount() + " patients had asthma.\n" +
                " " + request.asthmaAddressed() + " of the cases were addressed appropriately.\n";
        
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowAppointments(ActionEvent event) {
        //Reports patients who made appointments and whether they were kept
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" + 
                " " + request.getAppointmentCount() + " patients set up follow up appointments.\n" +
                " " + request.getAppointmentKeptCount() + " of those appointments were upheld.";
                
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonShowFullReport(ActionEvent event) {
        //Reports all of the patient information
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String reporttext = "";
        reporttext = "Of " + request.getSurveyCount() + " patients surveyed,\n" +
                " " + request.getAllergyQuestionedCount() + " were questioned about their allergies.\n" +
                " " + request.getTobaccoQuestionedCount() + " were questioned about tobacco use.\n" +
                " " + request.getAlcoholQuestionedCount() + " were questioned about alcohol consumption.\n" +
                " " + request.getDrugQuestionedCount() + " were questioned about illegal drug use.\n\n" +
                " " + request.getHypertensionCount() + " patients had hypertension.\n" +
                " " + request.hypertensionAddressed() + " of the cases were addressed appropriately.\n\n" +
                " " + request.getMentalHealthCount() + " patients had mental health disorders.\n" +
                " " + request.mentalHealthAddressed() + " of the cases were addressed appropriately.\n\n" +
                " " + request.getDiabetesCount() + " patients had diabetes.\n" +
                " " + request.diabetesAddressed() + " of the cases were addressed appropriately.\n\n" +
                " " + request.getAsthmaCount() + " patients had asthma.\n" +
                " " + request.asthmaAddressed() + " of the cases were addressed appropriately.\n\n" +
                " " + request.getAppointmentCount() + " patients set up follow up appointments.\n" +
                " " + request.getAppointmentKeptCount() + " of those appointments were upheld.\n\n" +
                "Of " + request.getSurveyCount() + " patients surveyed who identified their race,\n" +
                " " + request.getNumCaucasions() + " were caucasian.\n" +
                " " + request.getNumAfricanAmericans() + " were African Americans.\n" +
                " " + request.getNumOtherRaces() + " marked other.\n";
                
        report.setText(reporttext);
    }
    
    @FXML
    private void handleButtonSave(ActionEvent event) {
        //The save option handles saving when users want to save the report.
        FileChooser choice = new FileChooser();
        Stage stage = (Stage)report.getScene().getWindow();
        choice.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt files", "*.txt"));
        
        File newFile = choice.showSaveDialog(stage);
        FileWriter writer = null;
        
        if(newFile != null) {
            try{ 
                writer = new FileWriter(newFile);
                writer.write(report.getText());
            }   catch (IOException ie) {
                    System.out.println(ie.getMessage());
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    if(writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                  }
        }
    }
    
    @FXML
    private void handleButtonAbout(ActionEvent event) {
        about();
    }
    
    @FXML
    private void handleButtonQuit(ActionEvent event) {
        Stage stage = (Stage)report.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleButtonSQLSearch() {
        DatabaseSurveyQuery request = new DatabaseSurveyQuery();
        String search = sqlsearch.getText();
        System.out.println(search);
        int numrows = request.getSQLCount(search);
        String reporttext = "The number of surveys that match your query is " + numrows;
        report.setText(reporttext);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
    

