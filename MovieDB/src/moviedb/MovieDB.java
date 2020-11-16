/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 6
 * MovieDB 
 * This class is a database for movies, there is list of movies and ordered 
   tree set of IndexEntry. The MovieDB creates movies with unquie titles
   and print the list along the Index Entry of each movie in the list.
 */
package moviedb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovieDB {

    //initial capacity of the movie database (max number of movies stored) 
    private static final int INITIAL_CAPACITY = 20;
    //the number of movies in the starter movie database
    private static final int STARTER_MOVIEDB_SIZE = 15;
    //movie database, to be implemented as an array list
    private List<Movie> movieDB;
    //declare a data field named titleIndex for the index for movie titles
    private Set<IndexEntry> titleIndex;

    //constructor of MovieDB
    public MovieDB() {
        //create the objects for the empty movieDB and the empty index tree.
        movieDB = new ArrayList<Movie>();
        titleIndex = new TreeSet<IndexEntry>();
    }

    // create a starter movie DB: 
    //   movie format: Titlei (i -> random number [1, starter_db_size])
    //                 Directori (i is same as above) 
    //                 2019 
    public void createStartMovieDB() {
        Set<String> startMovies = new HashSet<String>();
        Random randNumGenerator = new Random();

        // keeps going until all starter movies are made
        while (startMovies.size() != STARTER_MOVIEDB_SIZE) {
            // gets random number [1, starter_db_size]
            int randNumber = randNumGenerator.nextInt(STARTER_MOVIEDB_SIZE) + 1;
            String title = "Title" + randNumber;
            String director = "Director" + randNumber;
            Movie newMovie = new Movie(title, director, 2019);

            // Checks if title id is unique -> true: adds, false: continues
            if (!startMovies.contains(title)) {
                startMovies.add(title);
                movieDB.add(newMovie);
            }
        }
    }

    //display the movies in the database in a tabular format
    // like the one in the sample output
    public void showMovieDB() {
        System.out.println("Movie Database: \n");

        System.out.println("          Title        Director   Year\n"
                + "------------------------------------------- ");

        // goes through each element in movieDB and prints infromation
        for (Movie current : movieDB) {
            String currentStr = "";
            currentStr += IntStream.range(0, 15 - current.getTitle().length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            currentStr += current.getTitle();

            currentStr += IntStream.range(0, 16 - current.getDirector().length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            currentStr += current.getDirector();

            currentStr += "   " + current.getYear();

            System.out.println(currentStr);
        }

        System.out.println("");
    }

    //create the index tree for all titles (unique) in current movieDB
    public void createIndex() {
        // iterates through movieDB to creat titleIndex based on position
        for (int i = 0; i < movieDB.size(); ++i) {
            IndexEntry newEntry = new IndexEntry(movieDB.get(i).getTitle(), i);
            titleIndex.add(newEntry);
        }
    }

    //display the title index in in a tabular format
    // like the one in the sample output
    public void showIndex() {
        System.out.println("Title Index: \n");

        System.out.println("          Title Location\n"
                + "------------------------------------------- ");

        // goes through each element in titleIndex and prints infromation
        for (IndexEntry current : titleIndex) {
            String currentStr = "";
            currentStr += IntStream.range(0, 15 - current.getTitle().length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            currentStr += current.getTitle();

            String n = (current.getLocation() < 10) ? "    " : "   ";
            currentStr += n + current.getLocation();

            System.out.println(currentStr);
        }

        System.out.println("");
    }

}
