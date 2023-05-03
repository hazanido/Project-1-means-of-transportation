package Graphic;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import Vehicle.*;


public class main_window extends JFrame {
    private ImageIcon logo;
    private JLabel label1;
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
        ImageIcon logo;
        JLabel display;
        try{
            logo=new ImageIcon(getClass().getResource("icon-03.png"));
            display=new JLabel(logo);
            this.add(display);
        }catch (Exception e){
            System.out.println("noooo");
        }

        //JButton button = new JButton("Adding \n vehicles");
        //button.setBounds(350, 350, 100, 100);
        //this.add(button);


        //button.addActionListener((e -> {


        //}));
    }
}


