package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents each music with its title, artist
public class Song implements Writable {
    private String artist;
    private String title;


    //EFFECTS: create a new song with its given artist and title
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;

    }

    // EFFECTS: returns the title of the song
    public String getTitle() {
        return title;
    }

    // EFFECTS: returns the artist of the song
    public String getArtist() {
        return artist;
    }

    public void setArtist(String name) {
        if (this.artist == null) {
            artist = name;
        }
    }

    public void setTitle(String name) {
        title += name;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("artist", artist);
        json.put("title", title);
        return json;
    }
}
