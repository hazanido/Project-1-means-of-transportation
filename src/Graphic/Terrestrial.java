package Graphic;

import javax.swing.*;
import java.awt.*;

public class Terrestrial extends JFrame {
    public Terrestrial(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Land transport vehicle");
        this.setLayout(new FlowLayout());

        JButton button1 = new JButton("Jeep");
        button1.setBounds(20, 100, 200, 200);
        this.add(button1);
        JButton button2 = new JButton("Amphibious vehicle");
        button2.setBounds(300, 100, 200, 200);
        this.add(button2);
        JButton button3 = new JButton("Bicycle");
        button3.setBounds(600, 100, 200, 200);
        this.add(button3);
    }
}
