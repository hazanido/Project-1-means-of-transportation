package Graphic;

import javax.swing.*;
import java.awt.*;

public class Aerial extends JFrame {
JButton dawn_Rigoli;
JButton game_drone;

    public Aerial(){
        this.setVisible(true);
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Air transport vehicles");

        JButton button1 = new JButton("Dawn_Rigoli");
        button1.setBounds(20, 100, 200, 200);
        this.add(button1);
        JButton button2 = new JButton("Game_Drone");
        button2.setBounds(300, 100, 200, 200);
        this.add(button2);


    }
}
