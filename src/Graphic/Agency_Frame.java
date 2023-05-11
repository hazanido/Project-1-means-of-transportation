package Graphic;

import Vehicle.Car_Agency;
import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Agency_Frame extends JFrame implements Test_drive1,Operations1,ActionListener {

    JLabel display;
    private static Dialog d;
    ImageIcon imageIcon;


    public Agency_Frame() {
        this.setVisible(true);
        this.setSize(1200, 1200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Agency");
        this.setLayout((new GridLayout()));


        for (int i = 0; i < Car_Agency.get_vehicle().length; i++) {
            int finalI=i;

            Vehicle vehicle = Car_Agency.get_vehicle()[i];
            BufferedImage image = null;
            try {
                image = ImageIO.read(vehicle.get_Photo());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            JButton button = new JButton(icon);
            button.addActionListener(e -> {
                //int temp = Car_Agency.get_vehicle()[finalI].get_move();
                //Car_Agency.get_vehicle()[finalI].set_Move(temp + update_move());

                /**int temp1 = update_move();

                Car_Agency.get_vehicle()[finalI].set_Move(temp*Car_Agency.get_vehicle()[finalI].get_move());

                 **/
                Operations frame = new Operations();

                this.dispose();


            });
            this.add(button);


            imageLabel.setIcon(imageIcon);
            setVisible(true);

        }

    }

    public int update_move() {
        JFrame f = new JFrame();

        JButton Back;
        JTextField move;

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

        String s = move.getText();
        int s1 = Integer.parseInt(s);
        return s1;

    }
    public boolean Update_after_purchase(){

        JFrame f = new JFrame();
        d=new Dialog(f,"Car purchase approval",true);
        d.setLayout(new FlowLayout());
        Button button=new Button("OK");
        d.add(new Label("The purchase was made successfully!!"));
        d.add(button);
        d.setSize(300,300);
        d.setVisible(true);
        return

    }










    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to the agency")) {
            Agency_Frame temp = new Agency_Frame();
            this.dispose();
        } else if (e.getActionCommand().equals("Test drive")) {
            int t=update_move();

            //Test_drive frame = new Test_drive();
            //this.dispose();

        } else if (e.getActionCommand().equals("Buying car")) {
            boolean p=Update_after_purchase();



        }
    }


    public void Operations() {
        JFrame frame = new JFrame();
        JButton test_drive, buying_car, Flag_change, Reset, Exit;

        frame.setVisible(true);
        frame.setSize(400, 320);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setTitle("test_drive or buying car");


        test_drive = new JButton("Test drive");
        buying_car = new JButton("Buying car");
        Flag_change = new JButton("Flag change");
        Reset = new JButton("Reset All");
        Exit = new JButton("Exit");


        test_drive.setBounds(30, 40, 150, 60);
        test_drive.addActionListener((ActionListener) frame);
        frame.add(test_drive);

        buying_car.setBounds(200, 40, 150, 60);
        buying_car.addActionListener((ActionListener) frame);
        frame.add(buying_car);

        Flag_change.setBounds(110, 120, 150, 60);
        Flag_change.addActionListener((ActionListener) frame);
        frame.add(Flag_change);

        Reset.setBounds(15, 240, 100, 30);
        Reset.addActionListener((ActionListener) frame);
        frame.add(Reset);

        Exit.setBounds(260, 240, 100, 30);
        Exit.addActionListener((ActionListener) frame);
        frame.add(Exit);

    }
}










