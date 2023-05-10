package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Agency_Frame extends JFrame implements Test_drive1 {

    JLabel display;
    ImageIcon imageIcon;
    private JButton Back;
    private JTextField move;


    public Agency_Frame()  {
        this.setVisible(true);
        this.setSize(1200, 1200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout((new GridLayout()));



        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {

            Vehicle vehicle = Car_Agency.get_vehicle()[i];
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicle.get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button=new JButton(icon);
            button.addActionListener(e->{
                Operations frame=new Operations();
                s1=update_move();
                this.dispose();


            });
            this.add(button);


            imageLabel.setIcon(imageIcon);
            setVisible(true);

        }

    }
    public int update_move() {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.gray);
        f.setTitle("Test_drive");

        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(15, 20, 150, 20);
        f.add(lebal1);
        move = new JTextField();
        move.setBounds(15, 50, 150, 20);
        move.setToolTipText("Please enter the distance you traveled on a test drive");


        Back = new JButton();
        Back.setBounds(20, 100, 150, 30);
        Back.setText("Back to the agency");
        Back.addActionListener((ActionListener) f);
        f.add(Back);
        f.add(move);
        String s= move.getText();
        int s1=Integer.parseInt(s);
        return s1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to the agency")) {

            Agency_Frame frame = new Agency_Frame();

            this.dispose();
        }

    }

}






