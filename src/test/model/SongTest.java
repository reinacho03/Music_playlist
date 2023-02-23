package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    private Song s1;
    private Song s2;

    @BeforeEach
    public void setUp() {
        s1 = new Song("Something about you", "Marilyn Ford");
        s2 = new Song("Awaken", "OY Studio");
    }

    @Test
    public void testConstructor() {
        assertEquals("Something about you", s1.getTitle());
        assertEquals("Marilyn Ford", s1.getArtist());

        assertEquals("Awaken", s2.getTitle());
        assertEquals("OY Studio", s2.getArtist());
    }

}
