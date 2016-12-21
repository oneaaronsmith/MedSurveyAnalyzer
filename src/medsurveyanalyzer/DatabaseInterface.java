/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public interface DatabaseInterface {
    //This interface enforces these functions to be included in a Database related class.
    public Connection connectToDatabase();  //This method would be important for any Database
    public ArrayList selectWholeTable();    //Selecting a whole table is also common
}
