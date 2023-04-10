package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This Class was adapted from CPSC 210 AlarmSystem-test
// https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git
public class EventTest {

    private Event e;
    private Date d;

    @BeforeEach
    public void runBefore() {
        e = new Event("New song added");
        d = Calendar.getInstance().getTime();
    }

    @Test
    public void testEvent() {
        assertEquals("New song added", e.getDescription());

    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "New song added", e.toString());
    }
}
