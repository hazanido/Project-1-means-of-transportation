package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Maritime extends JFrame implements ActionListener {
    JButton frigate;
    JButton Cruz;
    JButton Amphibious;

    public Maritime(){
        this.setVisible(true);
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Marine transport vehicle");
        this.setLayout(new FlowLayout());

        frigate = new JButton("Frigate");
        frigate.setBounds(20, 100, 200, 200);
        frigate.addActionListener(this);
        this.add(frigate);
        Cruz = new JButton("Cruise ship");
        Cruz.setBounds(300, 100, 200, 200);
        Cruz.addActionListener(this);
        this.add(Cruz);
        Amphibious = new JButton("Amphibious vehicle");
        Amphibious.setBounds(600, 100, 200, 200);
        Amphibious.addActionListener(this);
        this.add(Amphibious);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Frigate")) {
            frigate frame= new frigate();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Cruise ship")) {
            Cruz frame = new Cruz();
            this.dispose();

        }
        else if (e.getActionCommand().equals("Amphibious vehicle")) {
            Amphibious frame = new Amphibious();
            this.dispose();

        }
    }
}
