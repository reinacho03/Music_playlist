package persistence;

import model.PlayList;
import model.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

// This test class was adapted from CPSC 210 JsonSerialization-JsonReaderTest
public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNotExistingFile() {
        JsonReader reader = new JsonReader("./data/notExistingFile.json");
        try {
            PlayList pl = reader.read();
            pl.setUser("Roy");
            fail("IOException not thrown");
        } catch (IOException e) {
            //
        }
    }

    @Test
    public void testReaderEmptyPlayList() {
        try {
            PlayList pl = new PlayList();
            pl.setUser("Roy");
            JsonReader reader = new JsonReader("./data/testReaderEmptyPlayList.json");
            pl = reader.read();
            assertEquals(0, pl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralPlayList() {
        try {
            PlayList pl = new PlayList();
            pl.setUser("Roy");
            pl.addSong("Taylor Swift", "Anti Hero");
            pl.addSong("Ed Sheeran", "Perfect");

            JsonReader reader = new JsonReader("./data/testReaderGeneralPlayList.json");
            pl = reader.read();
            assertEquals("Roy", pl.getUser());
            List<Song> songs = pl.getSongs();
            assertEquals(2, songs.size());
            checkSong("Taylor Swift", "Anti Hero", songs.get(0));
            checkSong("Ed Sheeran", "Perfect", songs.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }

    }
}
