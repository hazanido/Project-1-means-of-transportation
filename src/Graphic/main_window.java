package Graphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
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
        this.setSize(1500, 1500);
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
            logo = new ImageIcon(getClass().getResource("logo.png"));
            display = new JLabel(logo);
            display.setBounds(500, 100, logo.getIconWidth(), logo.getIconHeight());
            this.add(display);

        }catch (Exception e){
            System.out.println("noooo");
            e.printStackTrace();
        }
        JLabel lebal = new JLabel("Car Agency");
        lebal.setBounds(300, 300, 300, 300);
        this.add(lebal);
        JButton button = new JButton("Adding vehicles");
        button.setBounds(300, 600, 300, 300);
        this.add(button);



    }
    public class Add_window extends JPanel {
        private JButton cmd;
        public Add_window() {
            cmd = new JButton("Adding vehicles");
            add(cmd);
           // Listener lis = new Listener();
        }


       // private class Listener implements ActionListener {
           // public void actionPerformed(ActionEvent e){
              //  Type_Vehicle t=new Type_Vehicle();
              //  cmd.setBackground(t);
           // }
        }
    }




