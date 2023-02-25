package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PlayListTest {
    private PlayList p1;

    @BeforeEach
    public void setUp() {
        p1 = new PlayList();
    }

    @Test
    public void testConstructor() {
        ArrayList<Song> emptyList = new ArrayList<>();
        assertEquals(emptyList, p1.getSongs());
    }

    @Test
    public void testAddSongToEmptyPlaylist() {
        p1.addSong("NCT DREAM", "Boom");
        assertEquals("NCT DREAM", p1.getSongs().get(0).getArtist());
        assertEquals("Boom", p1.getSongs().get(0).getTitle());
        assertEquals(1, p1.getSize());
    }


    @Test
    public void testAddSongMultipleSongs() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");

        assertEquals("STAYC", p1.getSongs().get(0).getArtist());
        assertEquals("Same Same", p1.getSongs().get(0).getTitle());
        assertEquals("Blackpink", p1.getSongs().get(1).getArtist());
        assertEquals("Lovesick Girls", p1.getSongs().get(1).getTitle());
        assertEquals(2, p1.getSize());
    }

    @Test
    public void testRemoveSongNotFoundSong() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");
        p1.removeSong("The Weeknd", "Out of Time");

        assertFalse(p1.findSong("The Weeknd"));
        assertEquals("STAYC", p1.getSongs().get(0).getArtist());
        assertEquals("Same Same", p1.getSongs().get(0).getTitle());
        assertEquals("Blackpink", p1.getSongs().get(1).getArtist());
        assertEquals("Lovesick Girls", p1.getSongs().get(1).getTitle());
        assertEquals(2, p1.getSize());
    }

    @Test
    public void testRemoveSongFoundSongSameArtistSameTitle() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");
        p1.removeSong("STAYC", "Same Same");

        assertFalse(p1.findSong("Same Same"));
        assertEquals("Blackpink", p1.getSongs().get(0).getArtist());
        assertEquals("Lovesick Girls", p1.getSongs().get(0).getTitle());
        assertEquals(1, p1.getSize());

    }

    @Test
    public void testRemoveSongFoundSongSameArtistDiffTitle() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");
        p1.removeSong("STAYC", "Teddy bear");

        assertFalse(p1.findSong("Teddy bear"));
        assertEquals("STAYC", p1.getSongs().get(0).getArtist());
        assertEquals("Same Same", p1.getSongs().get(0).getTitle());
        assertEquals("Blackpink", p1.getSongs().get(1).getArtist());
        assertEquals("Lovesick Girls", p1.getSongs().get(1).getTitle());
        assertEquals(2, p1.getSize());

    }

    @Test
    public void testFindSong() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");

        assertTrue(p1.findSong("Lovesick Girls"));
    }

    @Test
    public void testFindSongNotFound() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");

        assertFalse(p1.findSong("Butterfly"));
    }

    @Test
    public void testSearchSongNumberFoundSong() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");

        assertTrue(p1.findSong("Lovesick Girls"));
        assertEquals(1, p1.searchSongNumber("Lovesick Girls"));
    }

    @Test
    public void testSearchSongNumberNotFound() {
        p1.addSong("STAYC", "Same Same");
        p1.addSong("Blackpink", "Lovesick Girls");
        p1.addSong("Hwa Sa", "Maria");

        assertFalse(p1.findSong("Whistle"));
        assertEquals(-1, p1.searchSongNumber("Whistle"));
    }
}
