/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 1
 * StudentHiearchy 
 * This is a class tests the Student, Master and Undergraduate classes 
 */
package studenthiearchy;


public class StudentHiearchy {
    
    public static void main(String[] args) {
        Student[] cisDept = new Student[4];
        
        String[] theisCommittee = {"Tom", "Richard", "Jamie"};
        
        cisDept[0] = new MasterStudent("222", "Steve", "Jobs", "IST", "MS", 3.5,
                "How to make ipad smarter", "Jamie", theisCommittee);

        cisDept[1] = new Undergraduate("444", "Bill", "Gates", "CS", "BS", 3.0, 
                "Erin", "Sally");

        String[] theisCommittee2 = {"Jie", "Zoran", "Gene"};
        
        cisDept[2] = new MasterStudent("333", "Amy", "Jobs", "CS", "MS", 3.8,
                "Study of Robots That can Perform", "Eduard", theisCommittee2);

        cisDept[3] = new Undergraduate("111", "Melinda", "Gates", "IST", "BS", 
                3.0, "Erin", "Frank");

        // loops through the cisDept array and prints out the toString of the students 
        for (Student cisStudent : cisDept) {
            System.out.println(cisStudent.toString());
        }
        
        // prints first person in alphabetical order 
        int min = indexOfMin(cisDept); 
        System.out.println("\nFirst person in alphabetical order: \n" 
                + cisDept[min].toString() + "\n");
        
        //load the number of credits earned by all students
        cisDept[0].setNumberOfCreditsEarned(30);        
        cisDept[1].setNumberOfCreditsEarned(112);
        cisDept[2].setNumberOfCreditsEarned(40);   
         cisDept[1].setNumberOfCreditsEarned(125); 
         
        //load the decisions of committee members for all master students 
        boolean[] thesisCommitteeDecision = {true, true, true};
        ((MasterStudent)cisDept[0]).setCommitteeDecision(thesisCommitteeDecision);
        boolean[] thesisCommitteeDecision2 = {true, true, false};
        ((MasterStudent)cisDept[2]).setCommitteeDecision(thesisCommitteeDecision2);        
        
        // loop through student array and print graduation check.
        for (Student cisStudent : cisDept) {
            System.out.println(cisStudent.graduationCheck());
        }

    }

    // takes in list of students and returns the postion of first in alpha order
    public static int indexOfMin(Student[] myDept) {
        int minPos = 0;

        // loops through list compares to current smallest, updates if smaller
        for (int i = 0; i < myDept.length; ++i) {
            if (myDept[minPos].compareTo(myDept[i]) > 0) {
                minPos = i;
            }
        }

        return minPos;
    }
}
