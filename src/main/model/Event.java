package model;


import java.util.Calendar;
import java.util.Date;

// This Class was adapted from CPSC 210 AlarmSystem-model
// https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git
// Represents a music player system event
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;


    // EFFECTS: creates an event with the description and the current date
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }


    // EFFECTS: gets the date of the event
    public Date getDate() {
        return dateLogged;
    }

    // EFFECTS: gets the description of this event
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                && this.description.equals(otherEvent.description));
    }

    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
