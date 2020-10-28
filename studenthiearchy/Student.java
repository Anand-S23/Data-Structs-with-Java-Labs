/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 1
 * Student 
 * This is base student class, which containst all the methods that the masters
   and undergraduate class needs, some fields include id, name, major, degree, 
   gpa, number of credits earned
 */
package studenthiearchy;

public abstract class Student implements Comparable<Student> {
    private String id;
    private String firstName;
    private String lastName;
    private String major;
    private String degree;
    private double gpa;
    private int numberOfCreditsEarned;

    // Empty constructor
    public Student() {
    }

    // Constructor with all the fields 
    public Student(String id, String firstName, String lastName, String major,
            String degree, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.degree = degree;
        this.gpa = gpa;
    }

    //setters
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public void setNumberOfCreditsEarned(int numberOfCreditsEarned) {
        this.numberOfCreditsEarned = numberOfCreditsEarned;  
    }

    //getters
    public String getDegree() {
        return degree;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }
    
    public int getNumberOfCreditsEarned() {
        return this.numberOfCreditsEarned;
    }
    
    // Abstract method which is implemented in child classes
    public abstract boolean graduationCheck();

    @Override
    // Takes nothing as a parameter and returns a string representation of Student
    public String toString() {
        return "id: " + id + ", firstName: " + firstName + ", lastName: " + lastName
                + ", major: " + major + ", degree: " + degree + ", gpa: " + gpa;
    }

    @Override
    // Takes in another Student and compares to this Student based on last name 
    // first, if they are the same then compare the first name
    public int compareTo(Student o) {
        return (this.lastName.compareTo(o.lastName) != 0) ? 
                this.lastName.compareTo(o.lastName) : 
                this.firstName.compareTo(o.firstName);
    }
}
