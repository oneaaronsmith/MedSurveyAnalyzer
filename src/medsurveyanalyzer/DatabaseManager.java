/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class DatabaseManager implements DatabaseInterface{
    //The DatabaseManager class has common methods that would be useful for making
    //database queries.
    
    @Override
    public Connection connectToDatabase() {
        /*The only .db file to be used with this package is called survey.db
          Makes the SQLite connection or creates database if the file doesn't exist*/
        String url = "jdbc:sqlite:survey.db";
        //Try to connect to .db file and print error if unsuccessful
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("The connection was successful.");
                return DriverManager.getConnection(url);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //Prints an error if connection unsuccessful.
        }
        return null;
    }
    
    @Override
    public ArrayList selectWholeTable() {
        /*This method selects all the elements from the Survey table.
        The data I recieved was extrememly ugly, but I did the best I could to 
        provide useful information for the Medzou team.*/
        
        String query = "SELECT * FROM Survey";
        
        //An ArrayList collection class is used to store the String of each row.
        ArrayList<String> rows = new ArrayList<>();
        
        try(Connection conn = this.connectToDatabase();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(query)) {
            
            //Concatenate each row into one String and add it to the ArrayList rows
            while(result.next()) {
                String textresult = (result.getString("encounter") + "\t" +
                        result.getString("medzou_patient_number") + "\t\t" +
                        result.getString("visit_date") + "\t\t" +
                        result.getString("bp") + "\t" +
                        result.getString("weight (lb)") + "\t" +
                        result.getString("height_in (in)") + "\t" +
                        result.getString("was_the_patient_questioned_allergies") + "\t" +
                        result.getString("was_patient_questioned_tobacco_use") + "\t" +
                        result.getString("was_the_patient_questioned_etoh") + "\t" +
                        result.getString("was_patient_questioned_illicit_drugs") + "\t" +
                        result.getString("drug_type") + "\t" +
                        result.getString("htn") + "\t" +
                        result.getString("htn_addressed") + "\t" +
                        result.getString("dm") + "\t" +
                        result.getString("dm_addressed") + "\t" +
                        result.getString("mental_health") + "\t" +
                        result.getString("was_the_patient_s_mental_h") + "\t" +
                        result.getString("hx_or_ed_visit") + "\t" +
                        result.getString("does_the_patient_have_asth") + "\t" +
                        result.getString("was_the_asthma_addressed_i") + "\t" +
                        result.getString("was_a_follow_up_scheduled") + "\t" +
                        result.getString("was_this_follow_up_appoint") + "\t");
                rows.add(textresult);
                System.out.println(textresult);
            } 
        }
        catch (SQLException e) {
                    System.out.println(e.getMessage());
        }
        return rows;
    }
    
    /*This method takes in a SELECT COUNT(*) query and returns the number of rows for it.*/
    public int selectCount(String countquery) {
        String query = countquery;
        int querycount = 0;
        
        //Connect to the database and submit the query.
        try(Connection conn = this.connectToDatabase();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(query)) {
            while(result.next()) {
                querycount = Integer.parseInt(result.getString("count"));
                System.out.println(result.getString("count"));
            }
        } catch (SQLException e) {
                System.out.println(e.getMessage()); //Send message if unsuccessful.
        }
        
        return querycount; //Returns the row count.
    }
    
}
    


    

