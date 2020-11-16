/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 6
 * MovieDBConsole 
 * It is the program that tests the funtions implemented in MovieDB 
 */
package moviedb;

public class MovieDBConsole {

    public static void main(String[] args) {
        MovieDB myMovieDB = new MovieDB();
        myMovieDB.createStartMovieDB();
        myMovieDB.showMovieDB();

        myMovieDB.createIndex();
        myMovieDB.showIndex();
    }
}
