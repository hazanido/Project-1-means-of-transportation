package Graphic;

import Vehicle.Bicycle;
import Vehicle.Car_Agency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class bicycle extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed;
    private JRadioButton manual;
    private JComboBox cb,cb1;
    private JButton add,add_and_closs,add_photo;
    private File f;

    public bicycle(){
        this.setVisible(true);
        this.setSize(300, 670);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Bicycle");
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        model=new JTextField();
        model.setBounds(70,60,150,20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        this.add(lebal1);
        move=new JTextField();
        move.setBounds(70,110,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        this.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        this.add(lebal3);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        passengers.setToolTipText("please enter the number of passengers the vehicle contains");
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        this.add(lebal4);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal6 = new JLabel("Select a number of wheels:");
        lebal6.setBounds(70, 280, 250, 40);
        this.add(lebal6);
        String wheels[]={"2"};
        cb=new JComboBox(wheels);
        cb.setBounds(70,310,80,20);
        this.add(cb);

        JLabel lebal7 = new JLabel("Select an energy score:");
        lebal7.setBounds(70, 330, 250, 40);
        this.add(lebal7);
        String Score[]={"A"};
        cb1=new JComboBox(Score);
        cb1.setBounds(70,360,80,20);
        this.add(cb1);

        JLabel lebal8 = new JLabel("Select the power source");
        lebal8.setBounds(70, 390, 250, 40);
        this.add(lebal8);
        manual = new JRadioButton("manual");
        manual.setBounds(100,430,90,20);



        JLabel lebal9 = new JLabel("Please add photo:");
        lebal9.setBounds(70, 460, 250, 40);
        this.add(lebal9);
        add_photo = new JButton();
        add_photo.setBounds(100, 490, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        this.add(add_photo);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,560,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,560,120,50);



        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(manual);
        this.add(add);
        this.add(add_and_closs);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {
            String s1=model.getText();
            String s2=move.getText();
            String s3=distance.getText();
            String s4=passengers.getText();
            String s5=speed.getText();


            int s=Integer.parseInt(s2);
            double a=Double.parseDouble(s3);
            int b=Integer.parseInt(s4);
            double c=Double.parseDouble(s5);

            Bicycle temp1=new Bicycle(f,s1,s,a,b,c,2,null);
            Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();


        }
        else if(e.getActionCommand().equals("add photo")){
            Path to;

            JFileChooser photo=new JFileChooser();
            int i = photo.showOpenDialog(null);
            f=photo.getSelectedFile();

            to = Paths.get("src/Graphic/pictures/" + f.getName());
            try {
                Files.copy(f.toPath(),to.toFile().toPath());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

}
