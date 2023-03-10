package persistence;

import model.PlayList;
import model.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;

// This test class was adapted from CPSC 210 JsonSerialization-JsonWriterTest
public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            PlayList pl = new PlayList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was not thrown");
        } catch (IOException e) {
            //
        }
    }

    @Test
    public void testWriterEmptyPlayList() {
        try {
            PlayList pl = new PlayList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlayList.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlayList.json");
            pl = reader.read();
            assertEquals(0, pl.getSize());
        } catch (IOException e) {
            fail("Exception caught");
        }
    }

    @Test
    public void testWriterGeneralPlayList() {
        try {
            PlayList pl = new PlayList();
            pl.setUser("Roy");
            pl.addSong("Taylor Swift", "Anti Hero");
            pl.addSong("Ed Sheeran", "Perfect");
            JsonWriter writer= new JsonWriter("./data/testWriterGeneralPlayList.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlayList.json");
            pl = reader.read();
            assertEquals("Roy", pl.getUser());
            List<Song> songs = pl.getSongs();
            assertEquals(2, songs.size());
            checkSong("Taylor Swift", "Anti Hero", songs.get(0));
            checkSong("Ed Sheeran", "Perfect", songs.get(1));
        } catch (IOException e) {
            fail("Exception caught");
        }
    }
}
