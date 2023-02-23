package model;

// Represents each music with its title, artist, played times, and play minutes
public class Song {
    private String artist;
    private String title;


    //EFFECTS:
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }


    public String toString() {
        return artist + " - " + title;
    }
}
