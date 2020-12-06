/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 7
 * SummaryGenerator
 * A class which keeps track of the number of purchases from a particular country,
 + the createCountsByCountry takes data from a file and calucated the number of 
 + purchases by country and showCountsByCountry prints out the counts per country
 */
package summarygenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummaryGenerator {

    // data field which keeps track of the country purchase count
    private final Map countsByCountryMap;

    //the delimiter comma in the data file: purchases.csv
    private final String COMMA_DELIMITER = ",";

    // Empty constructor for SummaryGenerator
    public SummaryGenerator() {
        // includes both treemap and hashmap
        countsByCountryMap = new TreeMap<String, Integer>();
        // countsByCountryMap = new HashMap<String, Integer>();
    }

    // populates the countsByCountryMap with the data from the file
    public void createCountsByCountry(BufferedReader br) {
        //build country summary
        List<String> purchase = new ArrayList<>();
        try {
            String line;
            //read line by line until file reading is completed
            while ((line = br.readLine()) != null) {
                //split line to array using the delimiter comma,
                String[] fields = line.split(COMMA_DELIMITER);
                //convert the array to an ArrayList
                purchase = Arrays.asList(fields);

                // get all the values of the 7th column of the file
                String country = purchase.get(7);
                // chech if country is the label country
                if (!country.equals("Country")) {
                    // checks if country already in the map
                    if (countsByCountryMap.containsKey(country)) {
                        // adds one if it is 
                        Integer oldCount = (Integer) countsByCountryMap.get(country);
                        Integer newCount = Integer.valueOf(oldCount.intValue() + 1);
                        countsByCountryMap.put(country, newCount);
                    } else {
                        // adds the country to the map if not
                        countsByCountryMap.put(country, 1);
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");
            pse.printStackTrace();
            System.exit(1);
        }
    }

    //print the content of the data summary map in the format given in the sample output
    public void showCountsByCountry() {
        System.out.println("Country                       Count\n"
                + "------------------------------------------------------------");
        // for each through the countries in the map
        for (Object countryObj : countsByCountryMap.entrySet()) {
            // gets county name 
            String country = ((Map.Entry<String, Integer>) countryObj).getKey();
            // gets count value
            Integer count = ((Map.Entry<String, Integer>) countryObj).getValue();
            String spaces = "";
            // add the correct amount of space according to the lenght of country
            spaces += IntStream.range(0, 30 - country.length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            System.out.print(country + "" + spaces);
            printNChars('*', count.intValue());
        }
    }

    //print the character ch count number of times in one line
    private void printNChars(char ch, int count) {
        String stars = "";
        // adds the correct about of ch passed in to stars
        stars += IntStream.range(0, count)
                .mapToObj(i -> Character.toString(ch))
                .collect(Collectors.joining(""));
        System.out.println(stars);
    }
}
