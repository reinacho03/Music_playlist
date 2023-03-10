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
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlayList.json");
        try {
            PlayList pl = reader.read();
            pl.setUser("Roy");
            assertEquals("Roy", pl.getUser());
            assertEquals(0, pl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralPlayList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlayList.json");
        try {
            PlayList pl = reader.read();
            pl.setUser("Roy");
            assertEquals("Roy", pl.getUser());
            List<Song> songs = pl.getSongs();
            assertEquals(2, songs.size());
            checkSong("Sza", "Low", songs.get(0));
            checkSong("The Weeknd", "Die For You", songs.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
