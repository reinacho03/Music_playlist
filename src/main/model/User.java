package model;

import java.util.ArrayList;

// Represents user of the music player application
public class User {

    private String name;
    private ArrayList<Song> songs;

    // EFFECTS: create a new user with its name and new list of songs
    public User(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    // getters
    public String getUserName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
