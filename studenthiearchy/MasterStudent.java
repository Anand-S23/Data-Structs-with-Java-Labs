/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 1
 * MasterStudent 
 * This is a class which is a child class of the Student class, and is a 
   representation of a masters student. Master Student has a thesis, thesis 
   advisor and committee along side all the base data fields from Student
 */
package studenthiearchy;

public class MasterStudent extends Student {
    private String thesis;
    private String thesisAdvisor;
    private String[] committee; //thesis committee, excluding thesis advisor  
    private boolean[] committeeDecision; 

    // Empty Constructor
    public MasterStudent() {
    }

    // Constructor with all the fields 
    public MasterStudent(String id, String firstName, String lastName,
            String major, String degree, double gpa, String thesis, 
            String thesisAdvisor, String[] commitee) {
        super(id, firstName, lastName, major, degree, gpa);
        this.thesis = thesis;
        this.thesisAdvisor = thesisAdvisor;
        this.committee = commitee;
    }

    // getters 
    public String getThesis() {
        return this.thesis;
    }

    public String getThesisAdvisor() {
        return this.thesisAdvisor;
    }

    public String[] getCommittee() {
        return this.committee;
    }
    
    public boolean[] getCommitteeDecision() {
        return this.committeeDecision;
    }

    // setters 
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public void setThesisAdvisor(String thesisAdvisor) {
        this.thesisAdvisor = thesisAdvisor;
    }

    public void setCommitee(String[] committee) {
        this.committee = committee;
    }
    
    public void setCommitteeDecision(boolean[] committeeDecision) {
        this.committeeDecision = committeeDecision;
    }

    @Override
    // Takes in nothing as paramter and returns the toString of super with 
    // the new feilds of the master student appended on
    public String toString() {
        String retString = super.toString() + ",\n Thesis: " + this.thesis
                + ",\n Committee: [";

        for (String person : this.committee) {
            retString += person + ", ";
        }

        return retString.substring(0, retString.length() - 2) 
                + "],\n Thesis Advisor: " + this.thesisAdvisor;
    }

    @Override
    // Returns true or false if the student meets the requirement to pass, no parameters
    public boolean graduationCheck() {
        return this.getNumberOfCreditsEarned() >= 30 && this.getGpa() >= 3.0 &&
                this.committeeDecision[0] && this.committeeDecision[1] 
                && this.committeeDecision[2];
    }
}
