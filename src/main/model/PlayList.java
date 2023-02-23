package model;

import java.io.File;
import java.util.ArrayList;


// Represents playlist with list of songs and user of that playlist
public class PlayList {
    private ArrayList<Song> songs;
    private User user;
    private final int maxSize = 20;

    // EFFECTS: create a new playlist with the given username
    public PlayList(String userName) {
        songs = new ArrayList<>();
        this.user = new User(userName);
    }

    // MODIFIES: this
    // EFFECTS: add a song with its title and artist to the playlist
    public boolean addSong(String title, String artist) {
        if (findSong(title) == null) {
            Song s = new Song(title, artist);
            songs.add(s);
            return true;
        }
        return false;
    }

    // REQUIRES: the song already exists / is not null
    // MODIFIES: this
    // EFFECTS: remove a song with its title and artist to the playlist
    public boolean removeSong(String title, String artist) {
        if (findSong(title) != null) {
            songs.remove(findSong(title));
            return true;
        }
        return false;
    }

    // EFFECTS: returns true if the song exists in the playlist
    public Song findSong(String title) {
        Song foundSong = null;
        for (Song s: songs) {
            if (title.equals(s.getTitle())) {
                foundSong = s;
            }
        }
        return foundSong;
    }

    // EFFECTS: search a song from the list and return its index number
    public int searchSongNumber(String title) {
        int number = -1;
        if (findSong(title) != null) {
            for (int i = 0; i < songs.size(); i++) {
                if (title.equals(songs.get(i).getTitle())) {
                    number = i;
                }
            }
        }
        return number;
    }

    public User getUser() {
        return user;
    }

    public int getSize() {
        return songs.size();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
