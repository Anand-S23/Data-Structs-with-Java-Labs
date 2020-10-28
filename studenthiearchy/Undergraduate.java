/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 1
 * Undergraduate 
 * This is a class which is a child class of the Student class, and is a 
   representation of an undergraduate. An Undergraduate has a general education 
   advisor, and a major advisor along side all the base data fields from Student
 */
package studenthiearchy;

public class Undergraduate extends Student {
    private String generalEduAdvisor;
    private String majorAdvisor;

    // Empty Constructor
    public Undergraduate() {
    }

    // Constructor with all the fields 
    public Undergraduate(String id, String firstName, String lastName,
            String major, String degree, double gpa, String generalEduAdvisor, 
            String majorAdvisor) {
        super(id, firstName, lastName, major, degree, gpa);
        this.generalEduAdvisor = generalEduAdvisor;
        this.majorAdvisor = majorAdvisor;
    }

    // getters 
    public String getGeneralEduAdvisor() {
        return this.generalEduAdvisor;
    }

    public String getMajorAdvisor() {
        return this.majorAdvisor;
    }

    // setters
    public void setGeneralEduAdvisor(String generalEduAdvisor) {
        this.generalEduAdvisor = generalEduAdvisor;
    }

    public void setMajorAdvisor(String majorAdvisor) {
        this.majorAdvisor = majorAdvisor;
    }

    
    @Override
    // Returns string representation of undergraduate (base fields + undergrad fields)
    public String toString() {
        return super.toString() + ",\n General Education Advisor: "
                + this.generalEduAdvisor + ",\n Major Advisor: " + this.majorAdvisor;
    }

    @Override
    // Returns true or false depending on if undergrad has requirements of pass
    public boolean graduationCheck() {
        return this.getNumberOfCreditsEarned() >= 120 && this.getGpa() >= 2.0;
    }
}
