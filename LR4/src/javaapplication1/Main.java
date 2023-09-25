package javaapplication1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel lab1 = new JLabel("Один");
        JLabel lab2 = new JLabel("Два");
        JPanel panel = new JPanel();
        JButton butt1 = new JButton("Кнопка 1");
        JButton butt2 = new JButton("Кнопка 2");

        f.setSize(300, 200);
        f.setMinimumSize(new Dimension(300, 200));

        f.setLocation(500, 200);

        panel.add(lab1);
        panel.add(lab2);
        panel.add(butt1);
        panel.add(butt2);
        f.add(panel);
        f.pack();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}