package model;

// Represents each music with its title, artist, played times, and play minutes
public class Song {
    private String title;
    private String artist;
    private int playCount;
    private double playMinutes;


    //EFFECTS:
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        playCount = 0; 
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public double getPlayMinutes() {
        return playMinutes;
    }

    public String toString() {
        return "Song: " + title + " by " + artist;
    }
}
