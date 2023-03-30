package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel listPanel;

    private JButton addButton;
    private JButton removeButton;
    private JTextField input;

    public GUI() {
        super("Music Player");

        mainPanel();

        pack();

    }
    /*
else {
            JMenuItem source = (JMenuItem) (e.getSource());

            if (source.getText().equals("save")) {
                savePlayList();

            } else if (source.getText().equals("load")) {
                loadPlayList();

            } else if (source.getText().equals("quit")) {
                //

            }
        }


        if (e.getActionCommand().equals("1remove")) {
            selected = allSongs.getSongs().get(0);
            try {
                userSongs.removeSong(selected.getArtist(), selected.getArtist());
            } catch (Exception ex) {
                System.out.println("choose another one");
            }
            System.out.println("successfully removed");
            for (int i = 0; i < userSongs.getSize(); i++) {
                System.out.println("\t" + i + ": " + userSongs.getSongs().get(i).getArtist()
                        + " - " + userSongs.getSongs().get(i).getTitle());
            }
        }
        b1Remove.addActionListener(this);
        b1Remove.setActionCommand("1remove");
        b2Remove.addActionListener(this);
        b2Remove.setActionCommand("2remove");
        b3Remove.addActionListener(this);
        b3Remove.setActionCommand("3remove");
        b4Remove.addActionListener(this);
        b4Remove.setActionCommand("4remove");
        b1Remove = new JButton("X");
        b2Remove = new JButton("X");
        b3Remove = new JButton("X");
        b4Remove = new JButton("X");
        b4Remove.addActionListener(this);
        b4Remove.setActionCommand("4remove");

        b1.addActionListener(this);
        b1.setActionCommand("0");

        b2.addActionListener(this);
        b2.setActionCommand("1");

        b3.addActionListener(this);
        b3.setActionCommand("2");

        b4.addActionListener(this);
        b4.setActionCommand("3");

        box2.add(b1Remove);
        box2.add(b2Remove);
        box2.add(b3Remove);
        box2.add(b4Remove);
 */

    private void mainPanel() {
        init();
        addButton = new JButton("Add");
        addButton.setActionCommand("Add song");
        addButton.addActionListener(this);

        removeButton = new JButton("Remove");
        removeButton.setActionCommand("Remove song");
        removeButton.addActionListener(this);

        mainPanel.add(addButton);
        mainPanel.add(removeButton);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(300, 300, 100, 300));
        add(mainPanel);
        mainPanel.setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add song")) {
            //
        } else if (e.getActionCommand().equals("Remove song")) {
            //
        }
    }
}


/*
        userSongs = new PlayList();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(90, 90, 30, 90));
        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        frame.setJMenuBar(createMenuBar());

        l1 = new JLabel("Enter your name: ");
        l1.setBounds(10, 20, 150, 25);
        panel.add(l1);

        input = new JTextField(20);
        input.setBounds(10, 80, 165, 25);
        input.addActionListener(this);
        panel.add(input);

        frame.setTitle("Music Player");
        frame.pack();


        if (userSongs.getUser() != null) {
            frame2 = new JFrame();
            frame2.setVisible(true);
        }

        frame.setVisible(true);
         */
