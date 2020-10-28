/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 4
 * Person 
 * This class represents a person, who has a name, a degree, and skills. Based 
   on this a person is able to be hired. The skills are a list of programming 
   languages they know. 
 */
package hiringapp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author anand
 */
public class Person {
    // data fields: name, degree, skill list ("Java, C#, C++", etc.)
    private String name; 
    private String degree; 
    private ArrayList<String> skills;

    // constructor with given name, degree, and skill list
    public Person(String name, String degree, ArrayList<String> skills) {
        this.name = name; 
        this.degree = degree; 
        this.skills = skills;
    }

    // getters
    public String getName() {
        return this.name;
    }
    
    public String getDegree() {
        return this.degree;
    }
    
    public ArrayList<String> getSkills() {
        return this.skills;
    }

    // setters
    public void setName(String name) {
        this.name = name; 
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    // toString()
    @Override 
    public String toString() {
        String skillList = "Skills: ["; 
        Iterator<String> iter = this.skills.iterator();
        while (iter.hasNext()) {
            skillList += iter.next() + ", ";
        }
        
        skillList = skillList.substring(0, skillList.length() - 2) + "]";
        return "Name: " + this.name + ", Degree: " + this.degree + ", " + skillList;
    }
}
