package persistence;

import model.Song;
import static org.junit.jupiter.api.Assertions.assertEquals;

// This test class was adapted from CPSC 210 JsonSerialization-JsonTest
public class JsonTest {
    protected void checkSong(String artist, String title, Song song) {
        assertEquals(artist, song.getArtist());
        assertEquals(title, song.getTitle());
    }
}
