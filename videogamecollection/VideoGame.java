/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 2
 * VideoGame 
 * VidoGame is a class to represent a video game, with data fields such as title
   of the game, the lead developer of the game, the platforms the game is shiped 
   on and the release date. Throught this a list of games can be made for the 
   program, which manages video game list. 
 */
package videogamecollection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class VideoGame {
    // Data fields 
    private String title;
    private String developer; // lead developer 
    private String platforms[];
    private LocalDate releaseDate;

    // Empty constructor 
    public VideoGame() {
    }

    // Constructor that takes in values for all data fields
    public VideoGame(String title, String developer, String[] platforms,
            LocalDate releaseDate) {
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
    }

    // getters
    public String getTitle() {
        return this.title;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public String[] getPlatforms() {
        return this.platforms;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Returns the string of all the data fields for a video game concatenated
    @Override
    public String toString() {
        String retString = "Title: " + this.title + ", Lead Developer: "
                + this.developer + ", Platforms: [";

        // Loops through the platforms and concates each one onto retString
        for (String platform : platforms) {
            retString += platform + ", ";
        }

        // Formats date to format Sep. 20 2020
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String stringReleaseDate = format.format(this.releaseDate);

        return retString.substring(0, retString.length() - 2)
                + "], Release Date: " + stringReleaseDate;
    }

    // Takes is an object and checks if it has the same title (returns true if does) 
    @Override
    public boolean equals(Object otherObject) {
        VideoGame otherGame = (VideoGame) otherObject;
        return this.title.toLowerCase().equals(otherGame.getTitle().toLowerCase());
    }
}
