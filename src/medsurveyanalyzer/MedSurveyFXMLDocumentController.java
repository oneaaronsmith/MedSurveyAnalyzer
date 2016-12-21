/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Aaron
 */
public class MedSurveyFXMLDocumentController extends SceneSwitcher implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button quit; //Only added this button so I could retrieve stage
    
    @FXML
    private void handleButtonAnalyze(ActionEvent event) {
        //switches to analysis page
        switchController("MedSurveyAnalysisPageFXMLDocument");
    }
    
    @FXML
    private void handleButtonAbout(ActionEvent event) {
        //Shows "about" dialog
        about();
    }
    
    @FXML
    private void handleButtonQuit(ActionEvent event) {
        Stage stage = (Stage)quit.getScene().getWindow();
        stage.close();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
