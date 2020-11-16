/*
 * CIS2168 003 Data Structures or CIS2168 005 Data Structures
 * Anandsroop Singh - tul01835@temple.edu 
 * Assign 6
 * IndexEntry 
 * This class represents an Entry of List, which has the fields of title 
   and position of the item.
 */
package moviedb;

public class IndexEntry implements Comparable<IndexEntry> {

    @Override
    public int compareTo(IndexEntry other) {
        return title.compareTo(other.title);
    }

    private String title;
    private int location;

    public String getTitle() {
        return title;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public IndexEntry(String title, int location) {
        this.title = title;
        this.location = location;
    }

    @Override
    public String toString() {
        return "IndexEntry{" + "title=" + title + ", location=" + location + '}';
    }
}
