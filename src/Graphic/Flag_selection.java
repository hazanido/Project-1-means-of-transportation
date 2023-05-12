package Graphic;

import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Flag_selection extends JFrame implements ActionListener {

    private JButton Back, israel, usa, germany, greece, italy, sumulia, pirates;
    private JTextField move;
    private Vehicle vehicle;
    private int i;

    private BufferedImage b_israel,b_usa,b_germany,b_greece,b_italy,b_sumulia,b_pirates;

    private ImageIcon i_israel,i_usa,i_germany,i_greece,i_italy,i_sumulia,i_pirates;

    public Flag_selection(int i, Vehicle[] vehicles) {
        this.vehicle = vehicles[i];
        this.setVisible(true);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,3));
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Flag selection");

        try {
            b_germany = ImageIO.read(new File("src/Graphic/pictures/Germany.png"));
            b_israel = ImageIO.read(new File("src/Graphic/pictures/israel.png"));
            b_usa = ImageIO.read(new File("src/Graphic/pictures/usa.png"));
            b_greece = ImageIO.read(new File("src/Graphic/pictures/Greece.png"));
            b_italy = ImageIO.read(new File("src/Graphic/pictures/Italy.png"));
            b_sumulia = ImageIO.read(new File("src/Graphic/pictures/sumulia.png"));
            b_pirates = ImageIO.read(new File("src/Graphic/pictures/Pirates.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        i_germany=new ImageIcon(b_germany);
        i_israel=new ImageIcon(b_israel);
        i_usa=new ImageIcon(b_usa);
        i_greece=new ImageIcon(b_greece);
        i_italy=new ImageIcon(b_italy);
        i_sumulia=new ImageIcon(b_sumulia);
        i_pirates=new ImageIcon(b_pirates);
        //add button
        germany=new JButton(i_germany);
        israel=new JButton(i_israel);
        usa=new JButton(i_usa);
        greece=new JButton(i_greece);
        italy=new JButton(i_italy);
        sumulia=new JButton(i_sumulia);
        pirates=new JButton(i_pirates);

        this.add(germany);
        this.add(israel);
        this.add(usa);
        this.add(greece);
        this.add(italy);
        this.add(sumulia);
        this.add(pirates);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}