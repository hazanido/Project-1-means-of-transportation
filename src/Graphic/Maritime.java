package Graphic;

import javax.swing.*;
import java.awt.*;

public class Maritime extends JFrame {
    public Maritime(){
        this.setVisible(true);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");

        JButton button1 = new JButton("Frigate");
        button1.setBounds(20, 100, 200, 200);
        this.add(button1);
        JButton button2 = new JButton("Cruise ship");
        button2.setBounds(300, 100, 200, 200);
        this.add(button2);
        JButton button3 = new JButton("Amphibious vehicle");
        button3.setBounds(600, 100, 200, 200);
        this.add(button3);
    }
}
