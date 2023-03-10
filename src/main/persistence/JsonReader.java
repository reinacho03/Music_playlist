package persistence;

import model.PlayList;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Song;
import org.json.*;

// This Class was adapted from CPSC 210 JsonSerialization-Workroom
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
// Represents a reader that reads playlist from JSON data stored in file
public class JsonReader {
    private String source;

    // This method was adapted from JsonSerialization-JsonReader
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // This method was adapted from JsonSerialization-JsonReader
    // EFFECTS: throws IOException if there is an error when reading the file
    public PlayList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePlayList(jsonObject);
    }

    // This method was adapted from JsonSerialization-JsonReader
    // EFFECTS: reads source file as string and returns the source file
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // This method was adapted from JsonSerialization-JsonReader
    // EFFECTS: parses playlist from JSON object and returns it
    private PlayList parsePlayList(JSONObject jsonObject) {
        String user = jsonObject.getString("name");
        PlayList pl = new PlayList();
        pl.setUser(user);
        addItems(pl, jsonObject);
        return pl;
    }

    // This method was adapted from JsonSerialization-JsonReader
    // MODIFIES: this
    // EFFECTS: parses songs from JSON object and adds the songs to playlist
    private void addItems(PlayList pl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("songs");
        for (Object json: jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(pl, nextItem);
        }
    }

    // This method was adapted from JsonSerialization-JsonReader
    // MODIFIES: pl
    // EFFECTS: parses song from JSON object and adds it to playlist
    private void addItem(PlayList pl, JSONObject jsonObject) {
        String artist = jsonObject.getString("artist");
        String title = jsonObject.getString("title");
        Song song = new Song(artist, title);
        pl.addSong(song);
    }


}
