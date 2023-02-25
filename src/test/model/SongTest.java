package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    private Song s1;
    private Song s2;

    @BeforeEach
    public void setUp() {
        s1 = new Song("The Weeknd", "Out of Time");
        s2 = new Song("STAYC", "ASAP");
    }

    @Test
    public void testConstructor() {
        assertEquals("The Weeknd", s1.getArtist());
        assertEquals("Out of Time", s1.getTitle());

        assertEquals("STAYC", s2.getArtist());
        assertEquals("ASAP", s2.getTitle());

    }

}
