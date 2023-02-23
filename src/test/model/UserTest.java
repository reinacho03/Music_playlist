package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User u1;
    private User u2;

    @BeforeEach
    public void setUp() {
        u1 = new User("Jessica");
        u2 = new User("Lay");
    }

    @Test
    public void testConstructor() {
        assertEquals("Jessica", u1.getUserName());
        assertEquals("Lay", u2.getUserName());
        ArrayList<Song> emptyList = new ArrayList<>();
        assertEquals(emptyList, u1.getSongs());
        assertEquals(emptyList, u2.getSongs());
    }

}