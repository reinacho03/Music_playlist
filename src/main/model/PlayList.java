package model;

import java.io.File;
import java.util.ArrayList;


// Represents playlist with list of songs and the user of that playlist
public class PlayList {
    private ArrayList<Song> songs;
    private User user;
    private final int maxSize = 20;

    // EFFECTS: create a new playlist with the username not given yet
    public PlayList() {
        songs = new ArrayList<>();
        this.user = null;
    }

    // MODIFIES: this
    // EFFECTS: add a new song with its title and artist to the playlist
    public void addSong(String artist, String title) {
        Song s = new Song(artist, title);
        songs.add(s);
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

    // getters and setters
    public User getUser() {
        return user;
    }

    public int getSize() {
        return songs.size();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setUser(String userName) {
        user = new User(userName);
    }
}
