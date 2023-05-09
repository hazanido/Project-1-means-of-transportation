package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;
import Vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Agency_Frame extends JFrame implements ActionListener {
    Car_Agency agency;
    JLabel display;
    ImageIcon imageIcon;


    public Agency_Frame(){
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");




        JPanel carPanel = new JPanel(new GridLayout(20, 60, 700, 700));
        for (int i = 0; i <= agency.get_vehicle().length; i++) {

            if((agency.get_vehicle()[i] instanceof Bicycle)==true){
                imageIcon = new ImageIcon(getClass().getResource("/src/Graphic/pictures/bicycle1.png"));
                display = new JLabel(imageIcon);
                display.setBounds(15, 50, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                this.add(display);
                JButton button = new JButton(imageIcon);
                carPanel.add(button);
                add(carPanel, BorderLayout.CENTER);

                setVisible(true);

            }
            /**

            imageIcon = new ImageIcon(getClass().getResource(agency.get_vehicle()[i].getImagePath()));
            display = new JLabel(imageIcon);
            display.setBounds(500, 100, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            this.add(display);
            JButton button = new JButton(imageIcon);
            carPanel.add(button);
             **/
        }

        add(carPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }



}


