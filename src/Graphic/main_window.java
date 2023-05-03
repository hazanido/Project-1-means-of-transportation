package Graphic;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import Vehicle.*;


public class main_window extends JFrame {

    public static void main(String[] args) {
    new main_window();
    }

    public main_window() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Car Agency");

//set the label

        JLabel lebal = new JLabel("Car Agency");
        lebal.setBounds(300, 300, 300, 300);
        this.add(lebal);
        JButton button = new JButton("Adding vehicles");
        button.setBounds(300, 600, 300, 300);
        this.add(button);

        button.addActionListener((e -> {}));
    }
}


