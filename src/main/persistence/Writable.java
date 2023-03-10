package persistence;

import org.json.JSONObject;

// This Interface was adapted from CPSC 210 JsonSerialization-Writable
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
