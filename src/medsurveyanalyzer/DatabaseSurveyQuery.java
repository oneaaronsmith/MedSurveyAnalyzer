/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsurveyanalyzer;

/**
 *
 * @author Aaron
 */
public class DatabaseSurveyQuery extends DatabaseManager{
    //This subclass provides specific queries for use whenever a count is required.
    //It uses the selectCount method from its superclass often.
    
    public int getSurveyCount() {
        //Returns the number of rows in the survey table.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey");
        return count;
    }
    
    public int getSQLCount(String sqlstatement) {
        //Returns the number of rows given from the specific SQL query.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount(sqlstatement);
        return count;
    }
    
    public int getDrugQuestionedCount() {
        //Returns the number of surveys in which patients were asked about drug use.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_patient_questioned_illicit_drugs = '1'");
        return count;
    }
    
    public int getAllergyQuestionedCount() {
        //Returns the number of surveys in which patients were asked about allergies.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_the_patient_questioned_allergies = '1'");
        return count;
    }
    
    public int getAlcoholQuestionedCount() {
        //Returns the number of surveys in which patients were asked about alcohol
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_the_patient_questioned_etoh = '1'");
        return count;
    }
    
    public int getTobaccoQuestionedCount() {
        //Returns the number of surveys in which patients were asked about tobacco.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_patient_questioned_tobacco_use = '1'");
        return count;
    }
    
    public int getHypertensionCount() {
        //Returns the number of surveys in which the patients had hypertension.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE htn = '1'");
        return count;
    }
    
    public int hypertensionAddressed() {
        //Returns the number of surveys in which a patients hypertension was adequately addressed.
         int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE htn_addressed = '1'");
        return count;
    }
    
    public int getDiabetesCount() {
        //Returns the number of surveys in which patients had diabetes.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE dm = '1'");
        return count;
    }
    
    public int diabetesAddressed() {
        //Returns the number of surveys in which a patients diabetes was adequately addressed.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE dm = '1'");
        return count;
    }
    
    public int getMentalHealthCount() {
        //Returns the number of surveys in which patients had mental health disorders.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE mental_health = '1'");
        return count;
    }
    
    public int mentalHealthAddressed() {
        //Returns the number of surveys in which a patient's mental health was adequately addressed.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_the_patient_s_mental_h = '1'");
        return count;
    }
    
    public int getAsthmaCount() {
        //Returns the number of surveys in which patients had asthma.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE does_the_patient_have_asth = '1'");
        return count;
    }
    
    public int asthmaAddressed() {
        //Returns the number of surveys in which a patient's asthma was adequately addressed.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_the_asthma_addressed_i = '1'");
        return count;
    }
    
    public int getAppointmentCount() {
        //Returns the number of surveys in which patients made another appointment.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_a_follow_up_scheduled = '1'");
        return count;
    }
    
    public int getAppointmentKeptCount() {
        //Returns the number of surveys in which patients' appointments were kept
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE was_this_follow_up_appoint = '1'");
        return count;
    }
    
    public int getNumCaucasions() {
        //Returns the number of surveys in which patients identified themselves as cuacasion.
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE race = '1'");
        return count;
    }
    
    public int getNumAfricanAmericans() {
        //Returns the number of surveys in whic patients identified themselves as African American
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE race = '3'");
        return count;
    }
    
    public int getNumOtherRaces() {
        //Returns the number of surveys in which patients identified themselves as "Other"
        int count;
        DatabaseManager manage = new DatabaseManager();
        count = manage.selectCount("SELECT COUNT(*) AS count FROM Survey WHERE race = '2'");
        return count;
    }
}

