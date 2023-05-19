package Graphic.Vehicle_gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * A class representing an aerial vehicle selection window.
 *
 * Allows the user to choose between two types of aerial vehicles: Dawn_Rigoli and Game_Drone.
 */

public class Aerial extends JFrame implements ActionListener {
    private JButton dawn_Rigoli,game_Drone,plane_toy,spy_plane;
    private BufferedImage b_Aerial_photo,b_plane_toy,b_spy_plane;
    private ImageIcon i_Aerial_photo,i_plane_toy,i_spy_plane;

    /**
     * Constructs a new Aerial object.
     *
     * Initializes the window's properties and creates the two vehicle selection buttons.
     */

    public Aerial(){
        this.setVisible(true);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Air transport vehicles");


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Aerial_photo = ImageIO.read(new File("src/Graphic/pictures/TypeP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Aerial_photo = new ImageIcon(b_Aerial_photo);
        JLabel backgroundLabel = new JLabel(i_Aerial_photo);

        backgroundLabel.setBounds(0, 0, i_Aerial_photo.getIconWidth(), i_Aerial_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        try {
            b_plane_toy = ImageIO.read(new File("src/Graphic/pictures/plane toy.png"));
            b_spy_plane = ImageIO.read(new File("src/Graphic/pictures/Spy plane.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        i_spy_plane=new ImageIcon(b_spy_plane);
        i_plane_toy=new ImageIcon(b_plane_toy);

        plane_toy=new JButton(i_plane_toy);
        plane_toy.setBounds(90,170,90,60);
        panel.add(plane_toy);

        spy_plane=new JButton(i_spy_plane);
        spy_plane.setBounds(290,170,90,60);
        panel.add(spy_plane);







        dawn_Rigoli = new JButton("Dawn_Rigoli");
        dawn_Rigoli.setBounds(50, 80, 180, 80);
        dawn_Rigoli.addActionListener(this);
        panel.add(dawn_Rigoli);

        //this.add(dawn_Rigoli);
        game_Drone = new JButton("Game_Drone");
        game_Drone.setBounds(250, 80, 180, 80);
        game_Drone.addActionListener(this);
        panel.add(game_Drone);
        //this.add(game_Drone);


    }

    /**
     * Handles the user's button selection event.
     * Creates a new window of the selected vehicle type and disposes the current window.
     * @param e the action event triggered by the user's button selection
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Dawn_Rigoli")) {
            dawn_rigoli frame= new dawn_rigoli();
            this.dispose();
        }
        else if (e.getActionCommand().equals("Game_Drone")) {
            game_drone frame = new game_drone();
            this.dispose();

        }

    }
}
