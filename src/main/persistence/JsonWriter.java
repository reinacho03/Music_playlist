package persistence;

import org.json.JSONObject;
import model.PlayList;

import java.io.*;

// This class was adapted from CPSC 210 JsonSerialization-JsonWriter
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
// Represents a writer that writes JSON representation of playlist to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destinationFile;

    // This method was adapted from JsonSerialization-JsonWriter
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    // This method was adapted from JsonSerialization-JsonWriter
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if file cannot be
    // opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destinationFile));
    }

    // This method was adapted from JsonSerialization-JsonWriter
    // MODIFIES: this
    // EFFECTS: writes JSON representation of playlist to file
    public void write(PlayList pl) {
        JSONObject json = pl.toJson();
        saveToFile(json.toString(TAB));
    }

    // This method was adapted from JsonSerialization-JsonWriter
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // This method was adapted from JsonSerialization-JsonWriter
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
