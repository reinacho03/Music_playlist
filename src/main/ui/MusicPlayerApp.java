package ui;

import model.PlayList;
import model.Song;

import java.util.Scanner;
import java.util.ArrayList;


// Represents the music player application
public class MusicPlayerApp {

    private Scanner input;
    private ArrayList<Song> songs; // not instantiated yet
    private PlayList allSongs;
    private PlayList userSongs;


    // EFFECTS: create a new music player app
    public MusicPlayerApp() {
        runPlayer();
    }

    // EFFECTS: runs the player
    public void runPlayer() {
        boolean running = true;
        String command = null;
        String userName = null;

        init();

        System.out.println("Enter your name: ");
        userName = input.next();
        userSongs.setUser(userName);
        System.out.println(userName + "'s Music Playlist!");


        displayMenu();

        while (running) {
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                running = false;
            } else {
                process(command);
            }
        }
        System.out.println("Thanks for using our playlist");
    }

    private void init() {
        allSongs = new PlayList();
        allSongs.addSong("The Weeknd", "Die For You");
        allSongs.addSong("Sza", "Low");
        allSongs.addSong("Ed Sheeran", "Perfect");
        allSongs.addSong("Taylor Swift", "Anti Hero");

        userSongs = new PlayList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\te -> edit");
        System.out.println("\ts -> search");
        System.out.println("\tq -> quit");
    }

    private void process(String command) {
        if (command.equals("e")) {
            System.out.println("Select any song you want ^o^");
            System.out.println("List of Songs: ");
            displaySongLists(allSongs);

            int choice = input.nextInt();
            chooseSong(choice);

        } else if (command.equals("s")) {
            System.out.println("Type the name of the song you want ^o^");
            String searchName = input.next();
            searchSong(searchName);
        } else {
            System.out.println("Your selection is not valid");
        }
    }

    private void searchSong(String searchName) {
        int number = allSongs.searchSongNumber(searchName);

        if (number == -1) {
            System.out.println("Could not find the song. Try again.");
            displayMenu();
        } else {
            chooseSong(number);
        }

    }

    private void displaySongLists(PlayList songs) {
        for (int i = 0; i < songs.getSize(); i++) {
            System.out.println("\t" + i + ": " + songs.getSongs().get(i).getArtist()
                    + " - " + songs.getSongs().get(i).getTitle());
        }
    }

    private void chooseSong(int choice) {
        Song choose = allSongs.getSongs().get(choice);
        String artistName = choose.getArtist();
        String title = choose.getTitle();
        System.out.println("Your choice: " + artistName + " - " + title);

        System.out.println("\nSelect from:");
        System.out.println("\ta -> add this song to the playlist");
        System.out.println("\tr -> remove this song from the playlist");

        String selection = input.next();
        if (selection.equals("a")) {
            userSongs.addSong(artistName, title);
            System.out.println("Successfully added");
            displaySongLists(userSongs);
            displayMenu();

        } else if (selection.equals("r")) {
            userSongs.removeSong(artistName, title);
            System.out.println("Successfully removed");
            displaySongLists(userSongs);
            displayMenu();
        } else {
            System.out.println("invalid option try again");
            displayMenu();
        }

    }


}
