package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class movielibraryGUI {
    private JLabel Label1;
    private JLabel dodaj;
    private JPanel mainpanel;
    private JLabel edytuj;
    private JLabel lista;
    private JTextArea text1;
    private JTextField texttytul;
    private JPanel tytul;
    private JLabel ocena;
    private JTextField textcoena;
    private JLabel rodzaj;
    private JTextField textrodzaj;
    private JButton button1;
    private JLabel id2;
    private JTextField textid2;
    private JLabel tytul2;
    private JTextField texttytul2;
    private JLabel ocena2;
    private JTextField textocena2;
    private JLabel rodzaj2;
    private JTextField textrodzaj2;
    private JLabel usun;
    private JTextField textusun;
    private JButton button3;
    private JButton button2;

    public movielibraryGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Title = texttytul.getText();
                double Rating = Double.parseDouble(textcoena.getText());
                String Type = textrodzaj.getText();

                DatabaseOperations.addElement(Title, Rating,Type);

                texttytul.setText("");
                textcoena.setText("");
                textrodzaj.setText("");
                texttytul.requestFocus();

                text1.setText("");
                List<Movie> movieList = DatabaseOperations.displayElements();
                for (Movie movie : movieList) {
                    text1.append("ID: " + movie.getId() + ", Title: " + movie.getTitle() + ", Rating: " + movie.getRating() + ", Type: " + movie.getType() + "\n");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textusun.getText());

                DatabaseOperations.removeElement(id);
                textusun.setText("");

                text1.setText("");
                List<Movie> movieList = DatabaseOperations.displayElements();
                for (Movie movie : movieList) {
                    text1.append("ID: " + movie.getId() + ", Title: " + movie.getTitle() + ", Rating: " + movie.getRating() + ", Type: " + movie.getType() + "\n");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textid2.getText());
                String Title = texttytul2.getText();
                double Rating = Double.parseDouble(textocena2.getText());
                String Type = textrodzaj2.getText();

                DatabaseOperations.updateElement(id,Title,Rating,Type);

                texttytul2.setText("");
                textid2.setText("");
                textocena2.setText("");
                textrodzaj2.setText("");
                textid2.requestFocus();

                text1.setText("");
                List<Movie> movieList = DatabaseOperations.displayElements();
                for (Movie movie : movieList) {
                    text1.append("ID: " + movie.getId() + ", Title: " + movie.getTitle() + ", Rating: " + movie.getRating() + ", Type: " + movie.getType() + "\n");
                }
            }
        });

        text1.setText("");
        List<Movie> movieList = DatabaseOperations.displayElements();
        for (Movie movie : movieList) {
            text1.append("ID: " + movie.getId() + ", Title: " + movie.getTitle() + ", Rating: " + movie.getRating() + ", Type: " + movie.getType() + "\n");
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new movielibraryGUI().mainpanel);
        frame.setPreferredSize(new Dimension(700, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}