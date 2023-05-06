package Graphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import Vehicle.*;


public class main_window extends JFrame implements ActionListener {
    private ImageIcon logo;
    private JLabel label1;
    private Type_Vehicle vehicle;
    public static void main(String[] args) {
    new main_window();
    }
    private JButton button;


    public main_window() {


        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Car Agency");
        this.setVisible(true);

        JLabel lebal = new JLabel("Car Agency");
        lebal.setBounds(110, 10, 300, 30);
        this.add(lebal);


        button = new JButton("Adding vehicles");
        button.setBounds(90, 60, 110, 110);
        button.addActionListener(this);
        this.add(button);

    }
    public void actionPerformed(ActionEvent e){
        vehicle=new Type_Vehicle();
        this.dispose();

    }

}


//set the label
//        ImageIcon logo;
//       JLabel display;
//       try{
//           logo = new ImageIcon(getClass().getResource("/Graphic/pictures/logo.png"));
//          display = new JLabel(logo);
//           display.setBounds(500, 100, logo.getIconWidth(), logo.getIconHeight());
//           this.add(display);

//       }catch (Exception e){
//          System.out.println("noooo");
//           e.printStackTrace();
//       }