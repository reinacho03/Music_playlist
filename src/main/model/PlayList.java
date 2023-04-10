package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.io.File;
import java.util.ArrayList;

// This Class was adapted from CPSC 210 JsonSerialization-Workroom
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
// Represents playlist with list of songs and the user of that playlist
public class PlayList implements Writable {
    private ArrayList<Song> songs;
    private String name;
    private final int maxSize = 20;

    // EFFECTS: create a new playlist with the username not given yet
    public PlayList() {
        songs = new ArrayList<>();
        this.name = "";
    }

    // MODIFIES: this
    // EFFECTS: add a new song with its title and artist to the playlist
    public void addSong(String artist, String title) {
        Song s = new Song(artist, title);
        songs.add(s);

    }

    // MODIFIES: this
    // EFFECTS: adds a new song itself to the playlist
    public void addSong(Song s) {
        songs.add(s);
        EventLog.getInstance().logEvent(new Event("song added - "
                + s.getTitle() + " by " + s.getArtist()));
    }

    // REQUIRES: the song already exists / is not null
    // MODIFIES: this
    // EFFECTS: remove a song with its title and artist from the playlist
    public void removeSong(String artist, String title) {
        Song shouldBeRemoved = null;
        for (Song s: songs) {
            if (artist.equals(s.getArtist()) && title.equals(s.getTitle())) {
                shouldBeRemoved = s;
            }
        }
        if (shouldBeRemoved != null) {
            songs.remove(shouldBeRemoved);
            EventLog.getInstance().logEvent(new Event("song removed - "
                    + shouldBeRemoved.getTitle() + " by " + shouldBeRemoved.getArtist()));

        }


    }

    // EFFECTS: returns true if the song exists in the playlist
    public boolean findSong(String title) {
        boolean foundSong = false;
        for (Song s: songs) {
            if (title.equals(s.getTitle())) {
                foundSong = true;
            }
        }
        return foundSong;
    }

    // EFFECTS: search a song from the list and return its index number; -1 if not in the list
    public int searchSongNumber(String title) {
        int number = -1;
        if (findSong(title)) {
            for (int i = 0; i < songs.size(); i++) {
                if (title.equals(songs.get(i).getTitle())) {
                    number = i;
                }
            }
        }
        return number;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("songs", songsToJson());
        return json;
    }

    // EFFECTS:
    private JSONArray songsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Song s: songs) {
            jsonArray.put(s.toJson());
        }
        return jsonArray;
    }
    
    // getters and setters
    public String getUser() {
        return name;
    }

    public int getSize() {
        return songs.size();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setUser(String userName) {
        name += userName;
    }

}
