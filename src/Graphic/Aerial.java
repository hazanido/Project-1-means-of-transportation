package Graphic;

import javax.swing.*;
import java.awt.*;

public class Aerial extends JFrame {
JButton dawn_Rigoli;
JButton game_drone;

    public Aerial(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Air transport vehicles");
        this.setLayout(new FlowLayout());
        dawn_Rigoli = new JButton("Dawn_Rigoli");
        dawn_Rigoli.setBounds(20, 100, 200, 200);
        this.add(dawn_Rigoli);
        game_drone = new JButton("Game_Drone");
        game_drone.setBounds(300, 100, 200, 200);
        this.add(game_drone);


    }
}
