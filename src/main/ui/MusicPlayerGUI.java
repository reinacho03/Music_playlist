package ui;

import model.PlayList;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// Represents the user interface version of music player app
public class MusicPlayerGUI extends JPanel implements ActionListener {

    private JLabel l1;
    private JFrame frame;
    private JPanel startPanel;
    private JPanel selectionPanel;
    private JTextField input;
    private JButton buttonOk;
    private JTextArea textArea;

    private ImageIcon i1;
    private ImageIcon i2;
    private ImageIcon i3;
    private ImageIcon i4;

    private JLabel s1;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton buttonAdd;
    private JButton buttonRemove;

    private final String newline = "\n";
    private PlayList allSongs;
    private PlayList userSongs;
    private Song selected;


    
    public MusicPlayerGUI() {
        allSongs = new PlayList();
        allSongs.addSong("The Weeknd", "Die For You");
        allSongs.addSong("Sza", "Low");
        allSongs.addSong("Ed Sheeran", "Perfect");
        allSongs.addSong("Taylor Swift", "Anti Hero");

        userSongs = new PlayList();
        runPlayer();

    }

    public void runPlayer() {
        frame = new JFrame();
        frame.setJMenuBar(createMenuBar());
        frame.setSize(450, 450);

        buttonOk = new JButton("OK");
        buttonOk.setActionCommand("OK");
        buttonOk.addActionListener(this);

        l1 = new JLabel("Enter your name: ");

        input = new JTextField(10);
        input.addActionListener(this);

        initializeStartPanel();

        frame.add(startPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Music Player");
        frame.pack();
        frame.setVisible(true);

    }

    private void initializeStartPanel() {
        startPanel = new JPanel();
        startPanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 250, 200));
        startPanel.setLayout(new GridLayout());

        startPanel.add(l1);
        startPanel.add(input);
        startPanel.add(buttonOk);
    }



    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MusicPlayerGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();
        menu = new JMenu("menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);

        menuItem = new JMenuItem("save");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("load");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }


    public static void main(String[] args) {
        new MusicPlayerGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e instanceof javax.swing.JButton) {
            selected = new Song(null, null);
            if (e.getActionCommand().equals("OK")) {
                String text = input.getText();
                userSongs.setUser(text);
                System.out.println("User: " + text);
                selectionPanel();
            } else if (e.getActionCommand().equals("1")) {
                selected = allSongs.getSongs().get(0);
            } else if (e.getActionCommand().equals("2")) {
                selected = allSongs.getSongs().get(1);
            } else if (e.getActionCommand().equals("3")) {
                selected = allSongs.getSongs().get(2);
            } else if (e.getActionCommand().equals("4")) {
                selected = allSongs.getSongs().get(3);
            } else if (e.getActionCommand().equals("add")) {
                userSongs.addSong(selected);
                System.out.println("successfully added");
                textArea.append(selected.getArtist() + selected.getArtist() + " added" + newline);

            } else if (e.getActionCommand().equals("remove")) {
                try {
                    userSongs.removeSong(selected.getArtist(), selected.getArtist());
                } catch (Exception ex) {
                    System.out.println("choose another one");
                }
                System.out.println("successfully removed");
            }
        } else {
            JMenuItem source = (JMenuItem) (e.getSource());

            if (source.getText().equals("save")) {
                savePlayList();

            } else if (source.getText().equals("load")) {
                loadPlayList();

            } else if (source.getText().equals("quit")) {
                //

            }
        }// otherwise




    }



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

        setLabels();
        setBox();

        textArea = new JTextArea();
        selectionPanel.add(textArea);

        selectionPanel.setVisible(true);

    }

    private void setLabels() {
        s1 = new JLabel(userSongs.getUser() + "'s Music Playlist!"
                + newline);

        b1 = new JButton("The Weeknd - Die For You", i1);
        b2 = new JButton("Sza - Low", i2);
        b3 = new JButton("Ed Sheeran - Perfect", i3);
        b4 = new JButton("Taylor Swift - Antihero", i4);

        buttonAdd = new JButton("add");
        buttonRemove = new JButton("remove");
        buttonAdd.setPreferredSize(new Dimension(50, 50));
        buttonRemove.setPreferredSize(new Dimension(50, 50));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = allSongs.getSongs().get(0);
            }
        });
        b1.setActionCommand("1");

        b2.addActionListener();
        b2.setActionCommand("2");

        b3.addActionListener(this);
        b3.setActionCommand("3");

        b4.addActionListener(this);
        b4.setActionCommand("4");

        buttonAdd.addActionListener(this);
        buttonAdd.setActionCommand("add");

        buttonRemove.addActionListener(this);
        buttonRemove.setActionCommand("remove");
    }

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

        Box box2 = Box.createHorizontalBox();
        box2.add(buttonAdd);
        box2.add(Box.createHorizontalStrut(5));
        box2.add(buttonRemove);
        box2.add(Box.createHorizontalStrut(5));
        selectionPanel.add(box2);



    }


    public void savePlayList() {
        System.out.println("Saving...");
    }

    public void loadPlayList() {
        System.out.println("Loading...");
    }


}
