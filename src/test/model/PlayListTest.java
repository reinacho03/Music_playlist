package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PlayListTest {
    private PlayList p1;
    private PlayList p2;

    @BeforeEach
    public void setUp() {
        p1 = new PlayList("Jessica");
        p2 = new PlayList("Ray");
    }

    @Test
    public void testConstructor() {
        assertEquals("Jessica", p1.getUser().getUserName());
        assertEquals("Ray", p2.getUser().getUserName());
        ArrayList<Song> emptyList = new ArrayList<>();
        assertEquals(emptyList, p1.getSongs());
        assertEquals(emptyList, p2.getSongs());
    }

    @Test
    public void testAddSongToEmptyPlaylist() {
        assertTrue(p1.addSong("A", "1"));
        assertEquals(1, p1.getSize());
    }

    @Test
    public void testAddSongFoundSong() {
        assertTrue(p1.addSong("A", "1"));
        assertFalse(p1.addSong("A", "1"));
        assertEquals(1, p1.getSize());
    }

    @Test
    public void testAddSongMultipleSongs() {
        assertTrue(p2.addSong("A", "1"));
        assertTrue(p2.addSong("B", "2"));
        assertEquals(2, p2.getSize());
    }

    @Test
    public void testRemoveSongNotFoundSong() {
        p1.addSong("A", "1");
        assertFalse(p1.removeSong("B", "2"));
        assertEquals(1, p1.getSize());
    }

    @Test
    public void testRemoveSongFoundSong() {
        p1.addSong("A", "1");
        p1.addSong("B", "2");
        assertTrue(p1.removeSong("A", "1"));
        assertEquals(1, p1.getSize());
    }

    @Test
    public void testFindSong() {
        p1.addSong("A", "1");
        p1.findSong("A");
        assertEquals("A", p1.getSongs().get(0).getTitle());
        assertEquals("1", p1.getSongs().get(0).getArtist());
    }

    @Test
    public void testSearchSongNumberFoundSong() {
        p1.addSong("A", "1");
        p1.addSong("B", "2");
        p1.addSong("C", "3");

        assertEquals(1, p1.searchSongNumber("B"));
    }

    @Test
    public void testSearchSongNumberNotFound() {
        p1.addSong("A", "1");
        p1.addSong("B", "2");
        p1.addSong("C", "3");

        assertEquals(-1, p1.searchSongNumber("D"));
    }
}
