package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Type_Vehicle extends JFrame implements ActionListener{
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public Type_Vehicle() {
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
        this.setLayout(new FlowLayout());

        button1 = new JButton("Air transport vehicles");
        //Listener lis = new Listener();
        button1.addActionListener(this);
        this.add(button1);
        button2 = new JButton("Land transport vehicle");
        //Listener lis1 = new Listener();
        button2.addActionListener(this);
        this.add(button2);
        button3 = new JButton("Marine transport vehicle");

        //Listener lis2 = new Listener();
        button3.addActionListener(this);
        this.add(button3);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Marine transport vehicle")) {
            Maritime type_M = new Maritime();
            button3.add(type_M);
        }
        else if (e.getActionCommand().equals("Land transport vehicle")) {
            Terrestrial type_M = new Terrestrial();
            button2.add(type_M);

        } else if (e.getActionCommand().equals("Air transport vehicles")) {
            Aerial type_M = new Aerial();
            button1.add(type_M);
        }

    }

}

