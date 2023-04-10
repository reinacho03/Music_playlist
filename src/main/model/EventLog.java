package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// This Class was adapted from CPSC 210 AlarmSystem-modelß
// https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git
// Represents a log of music player events
public class EventLog implements Iterable<Event> {

    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: instantiates an event log object
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: gets an instance of EventLog
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // EFFECTS: adds an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: clears the event log and logs the event
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));

    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
