package ui;

import model.Event;
import model.EventLog;
import model.PlayList;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


// Represents the Graphic User Interface of the music player app
public class MusicPlayerGUI extends JPanel implements ActionListener {
    private static final String JSON_STORE = "./data/myPlayList.json";
    private JLabel l1;
    private JFrame frame;
    private JPanel startPanel;
    private JPanel selectionPanel;
    private JTextField input;
    private JButton buttonOk;
    private JTextArea textArea = new JTextArea();

    private ImageIcon i1;
    private ImageIcon i2;
    private ImageIcon i3;
    private ImageIcon i4;

    private JLabel s1;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    private JButton b1Add;
    private JButton b2Add;
    private JButton b3Add;
    private JButton b4Add;
    private JButton b1Remove;
    private JButton b2Remove;
    private JButton b3Remove;
    private JButton b4Remove;


    private final String newline = "\n";
    private PlayList allSongs;
    private PlayList userSongs;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: initializes and runs the music player
    public MusicPlayerGUI() {
        allSongs = new PlayList();
        allSongs.addSong("The Weeknd", "Die For You");
        allSongs.addSong("Sza", "Low");
        allSongs.addSong("Ed Sheeran", "Perfect");
        allSongs.addSong("Taylor Swift", "Anti Hero");

        userSongs = new PlayList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        runPlayer();

    }

    // MODIFIES: this
    // EFFECTS: set the frame and add the panel to the frame
    public void runPlayer() {
        frame = new JFrame();
        frame.setJMenuBar(createMenuBar());
        frame.setSize(450, 450);

        initializeStartPanel();

        frame.add(startPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Music Player");

        frame.pack();
        frame.setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: initializes the start panel and all the components
    private void initializeStartPanel() {
        startPanel = new JPanel();
        startPanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 250, 200));
        startPanel.setLayout(new GridLayout());

        buttonOk = new JButton("OK");
        buttonOk.setActionCommand("OK");
        buttonOk.addActionListener(this);

        input = new JTextField(10);
        input.addActionListener(this);

        l1 = new JLabel("Enter your user name");
        l1.setFont(new Font("SansSerif", Font.BOLD, 24));

        Box box = Box.createVerticalBox();
        box.add(l1);
        box.add(Box.createVerticalStrut(15));
        box.add(input);
        box.add(Box.createVerticalStrut(20));
        box.add(buttonOk);

        startPanel.add(box);

    }



    // EFFECTS: creates an image icon for the images
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MusicPlayerGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    // EFFECTS: create a menu bar for the music player
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem1;
        JMenuItem menuItem2;
        JMenuItem menuItem3;

        menuBar = new JMenuBar();
        menu = new JMenu("menu");
        menuBar.add(menu);

        menuItem1 = new JMenuItem("save");
        menuItem1.setActionCommand("save");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("load");
        menuItem2.setActionCommand("load");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        menuItem3 = new JMenuItem("quit");
        menuItem3.setActionCommand("quit");
        menuItem3.addActionListener(this);
        menu.add(menuItem3);

        return menuBar;
    }


    public static void main(String[] args) {
        new MusicPlayerGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("OK")) {
            userSongs.setUser(input.getText());
            selectionPanel();
        }

        songItemCommands(command);

        if (command.equals("save")) {
            savePlayList();
        }
        if (command.equals("load")) {
            loadPlayList();
        }
        if (command.equals("quit")) {
            quitPlayList();
        }

    }

    private void songItemCommands(String command) {
        if (command.equals("1add")) {
            addSong(0);
        } else if (command.equals("2add")) {
            addSong(1);
        } else if (command.equals("3add")) {
            addSong(2);
        } else if (command.equals("4add")) {
            addSong(3);
        }

        if (command.equals("1remove")) {
            removeSong(0);
        } else if (command.equals("2remove")) {
            removeSong(1);
        } else if (command.equals("3remove")) {
            removeSong(2);
        } else if (command.equals("remove")) {
            removeSong(3);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the song of the selected index to the user play list
    private void addSong(int selection) {
        Song selected = allSongs.getSongs().get(selection);
        userSongs.addSong(selected);
        display();
    }

    private void removeSong(int selection) {
        Song selected = allSongs.getSongs().get(selection);
        userSongs.removeSong(selected.getArtist(), selected.getTitle());
        display();
    }

    // EFFECTS: displays the list of the songs to the text area
    private void display() {
        for (int i = 0; i < userSongs.getSize(); i++) {
            textArea.append("=>" + userSongs.getSongs().get(i).getArtist()
                    + " - " + userSongs.getSongs().get(i).getTitle() + newline);
        }
        textArea.append(newline);
    }

    // MODIFIES: this
    // EFFECTS: create a new selection panel and add the components
    private void selectionPanel() {
        startPanel.setVisible(false);

        selectionPanel = new JPanel();
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 90));
        selectionPanel.setLayout(new GridLayout());

        frame.add(selectionPanel);

        i1 = createImageIcon("images/dieforyou.gif");
        i2 = createImageIcon("images/low.gif");
        i3 = createImageIcon("images/perfect.gif");
        i4 = createImageIcon("images/antihero.gif");


        settingSelectionPanel();
        setBox();

        textArea = new JTextArea();
        JScrollPane sp = new JScrollPane(textArea);

        selectionPanel.add(sp);

        selectionPanel.setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: set the buttons and labels for the selection panel
    private void settingSelectionPanel() {
        s1 = new JLabel(userSongs.getUser() + "'s Music Playlist!"
                + newline);

        setButtons();

        b1Add.addActionListener(this);
        b1Add.setActionCommand("1add");

        b2Add.addActionListener(this);
        b2Add.setActionCommand("2add");

        b3Add.addActionListener(this);
        b3Add.setActionCommand("3add");

        b4Add.addActionListener(this);
        b4Add.setActionCommand("4add");

        b1Remove.addActionListener(this);
        b1Remove.setActionCommand("1remove");

        b2Remove.addActionListener(this);
        b2Remove.setActionCommand("2remove");

        b3Remove.addActionListener(this);
        b3Remove.setActionCommand("3remove");

        b4Remove.addActionListener(this);
        b4Remove.setActionCommand("4remove");

    }

    private void setButtons() {
        b1 = new JButton("The Weeknd - Die For You", i1);
        b2 = new JButton("Sza - Low", i2);
        b3 = new JButton("Ed Sheeran - Perfect", i3);
        b4 = new JButton("Taylor Swift - Antihero", i4);

        b1Add = new JButton("O");
        b2Add = new JButton("O");
        b3Add = new JButton("O");
        b4Add = new JButton("O");

        b1Remove = new JButton("X");
        b2Remove = new JButton("X");
        b3Remove = new JButton("X");
        b4Remove = new JButton("X");
    }

    // MODIFIES: this
    // EFFECTS: aligns the buttons using Box
    private void setBox() {
        Box box = Box.createVerticalBox();
        box.add(s1);
        box.add(Box.createVerticalStrut(10));
        box.add(b1);
        box.add(Box.createVerticalStrut(10));
        box.add(b2);
        box.add(Box.createVerticalStrut(10));
        box.add(b3);
        box.add(Box.createVerticalStrut(10));
        box.add(b4);
        box.add(Box.createVerticalStrut(10));

        selectionPanel.add(box);

        arrangeAddRemoveButtons();

    }

    // EFFECTS: arranges the add and remove buttons for each song item
    private void arrangeAddRemoveButtons() {
        Box box2 = Box.createVerticalBox();

        ArrayList<JButton> buttonList = new ArrayList<>();
        buttonList.add(b1Add);
        buttonList.add(b2Add);
        buttonList.add(b3Add);
        buttonList.add(b4Add);

        displayButtons(buttonList, box2, 50);

        Box box3 = Box.createVerticalBox();
        ArrayList<JButton> buttonList2 = new ArrayList<>();
        buttonList2.add(b1Remove);
        buttonList2.add(b2Remove);
        buttonList2.add(b3Remove);
        buttonList2.add(b4Remove);

        displayButtons(buttonList2, box3, 50);

        Box box4 = Box.createHorizontalBox();
        box4.add(box2);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(box3);
        box4.add(Box.createHorizontalStrut(10));
        selectionPanel.add(box4);


    }

    // EFFECTS: add the vertical strut between each button
    private void displayButtons(ArrayList<JButton> buttonList, Box box, int height) {
        for (int i = 0; i < buttonList.size(); i++) {
            box.add(buttonList.get(i));
            box.add(Box.createVerticalStrut(height));

        }

    }

    // MODIFIES: this
    // EFFECTS: saves the list of playlist
    public void savePlayList() {
        System.out.println("Saving...");
        try {
            jsonWriter.open();
            jsonWriter.write(userSongs);
            jsonWriter.close();
            System.out.println("Saved " + userSongs.getUser() + "'s playlist to " + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to put to file: " + JSON_STORE);
        }
        textArea.append("Saved!" + newline);
        display();
    }

    // MODIFIES: this
    // EFFECTS: loads the list of playlist
    public void loadPlayList() {
        System.out.println("Loading...");
        try {
            userSongs = jsonReader.read();
            System.out.println("Loaded " + userSongs.getUser() + "'s playlist from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        textArea.append("Loaded!" + newline);
        display();
    }

    // MODIFIES: this
    // EFFECTS: ends the music player app
    public void quitPlayList() {
        System.out.println("Quit!");
        frame.dispose();

        System.out.println("Logged events:");
        for (Event event : EventLog.getInstance()) {
            System.out.println(event.toString() + "\n");
        }

        frame.setVisible(false);
    }



}
