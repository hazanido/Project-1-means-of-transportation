package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Type_Vehicle extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public Type_Vehicle() {
        this.setVisible(true);
        this.setSize(850, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");

        button1 = new JButton("Air transport vehicles");
        button1.setBounds(20, 100, 200, 200);
        Listener lis = new Listener();
        button1.addActionListener(lis);
        this.add(button1);
        button2 = new JButton("Land transport vehicle");
        button2.setBounds(300, 100, 200, 200);
        Listener lis1 = new Listener();
        button2.addActionListener(lis1);
        this.add(button2);
        button3 = new JButton("Marine transport vehicle");
        button3.setBounds(600, 100, 200, 200);
        Listener lis2 = new Listener();
        button3.addActionListener(lis2);
        this.add(button3);


    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Maritime type_M = new Maritime();
            //button3.add(type_M);

        }

    }
}

