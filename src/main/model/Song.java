package model;

// Represents each music with its title, artist
public class Song {
    private String artist;
    private String title;


    //EFFECTS: create a new song with its given artist and title
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;

    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }



}
