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
