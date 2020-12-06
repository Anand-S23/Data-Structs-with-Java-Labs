/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 7
 * SummaryGeneratorTest 
 * Tests the methods implented in SummaryGenerator class - tests the construtor,  
 + createCountsByCountry, and showCountsByCountry
 */
package summarygenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SummaryGeneratorTest {

    public static void main(String[] args) {
        try {
            //create a BufferedReader to read from file purchases.csv
            BufferedReader br = new BufferedReader(new FileReader("purchases.csv"));
            SummaryGenerator gen = new SummaryGenerator();
            gen.createCountsByCountry(br);
            gen.showCountsByCountry();
        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        }
    }

}
