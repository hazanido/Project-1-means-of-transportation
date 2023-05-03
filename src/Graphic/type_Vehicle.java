package Graphic;

import javax.swing.*;
import java.awt.*;

public class Type_Vehicle extends JFrame{
    public Type_Vehicle(){
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");

        JButton button1 = new JButton("Air transport vehicles");
        button1.setBounds(300, 600, 300, 300);
        this.add(button1);
        JButton button2 = new JButton("Land transport vehicle");
        button2.setBounds(300, 600, 300, 300);
        this.add(button2);
        JButton button3 = new JButton("Marine transport vehicle");
        button3.setBounds(300, 600, 300, 300);
        this.add(button3);

    }

}



