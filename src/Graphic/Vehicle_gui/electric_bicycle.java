package Graphic.Vehicle_gui;

import Graphic.Agency_Frame;
import Graphic.Threads_class;
import Graphic.main_window;
import Vehicle.Car_Agency;
import Vehicle.ElectricBicycle;
import Vehicle.NonMotorizedBicycle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class electric_bicycle extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed,lifetime;
    private JRadioButton manual;
    private JComboBox cb,cb3;
    private JButton add,add_and_closs,add_photo;
    private File f;
    private BufferedImage b_Definitions_photo;
    private ImageIcon i_Definitions_photo;

    /**
     * Constructs a new bicycle object and initializes its GUI components.
     * The method also initializes all the text fields and labels that will be displayed on the frame,
     * sets their positions and sizes, and adds them to the frame.
     */
    public electric_bicycle(){
        // Set window properties
        this.setVisible(true);
        this.setSize(300, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Electric Bicycle");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Definitions_photo = ImageIO.read(new File("src/Graphic/pictures/Definitions1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Definitions_photo = new ImageIcon(b_Definitions_photo);
        JLabel backgroundLabel = new JLabel(i_Definitions_photo);

        backgroundLabel.setBounds(0, 0, i_Definitions_photo.getIconWidth(), i_Definitions_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);

        // Add components to the window
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        panel.add(lebal);
        model=new JTextField();
        model.setBounds(70,60,150,20);
        model.setToolTipText("please enter model of car");
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 90, 150, 20);
        panel.add(lebal1);
        move=new JTextField();
        move.setBounds(70,110,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 140, 150, 20);
        panel.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,160,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("passengers:");
        lebal3.setBounds(70, 190, 150, 20);
        panel.add(lebal3);
        passengers=new JTextField();
        passengers.setBounds(70,210,150,20);
        passengers.setToolTipText("please enter the number of passengers the vehicle contains");
        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 240, 150, 20);
        panel.add(lebal4);
        speed=new JTextField();
        speed.setBounds(70,260,150,20);
        speed.setToolTipText("Please type the maximum speed of the vehicle");

        JLabel lebal5 = new JLabel("lifetime:");
        lebal5.setBounds(70, 290, 150, 20);
        panel.add(lebal5);
        lifetime = new JTextField();
        lifetime.setBounds(70, 310, 150, 20);
        lifetime.setToolTipText("Please type the average lifetime of the engine");

        JLabel lebal6 = new JLabel("Select a number of wheels:");
        lebal6.setBounds(70, 330, 250, 40);
        panel.add(lebal6);
        String wheels[]={"2"};
        cb=new JComboBox(wheels);
        cb.setBounds(70,360,80,20);
        panel.add(cb);

        JLabel lebal7 = new JLabel("Average fuel consumption:");
        lebal7.setBounds(70, 390, 250, 40);
        panel.add(lebal7);
        String fuel_consumption[]={"20"};
        cb=new JComboBox(fuel_consumption);
        cb.setBounds(70,420,80,20);
        panel.add(cb);

        JLabel lebal18 = new JLabel("Select a color of car:");
        lebal18.setBounds(70, 450, 250, 40);
        panel.add(lebal18);

        String wheels1[] = {"green","blue","red"};
        cb3 = new JComboBox(wheels1);
        cb3.setBounds(70, 480, 120, 20);
        panel.add(cb3);


        JLabel lebal9 = new JLabel("Please add photo:");
        lebal9.setBounds(70, 500, 250, 40);
        panel.add(lebal9);
        add_photo = new JButton();
        add_photo.setBounds(100, 530, 90, 50);
        add_photo.setText("add photo");
        add_photo.addActionListener(this);
        panel.add(add_photo);

        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,590,120,50);
        add.addActionListener(this);


        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,590,120,50);
        add_and_closs.addActionListener(this);



        panel.add(model);
        panel.add(move);
        panel.add(distance);
        panel.add(passengers);
        panel.add(speed);
        panel.add(add);
        panel.add(add_and_closs);
        panel.add(lifetime);

    }
    /**
     *This method processes an ActionEvent, which is generated when the user interacts with the GUI.
     *
     * The method reads data from various input fields in the GUI, creates a new vehicle object based on the input,
     * If the "add photo" button is pressed, the method opens a file chooser dialog and allows the user to select a photo file,
     * which is then copied to a designated folder.
     * If we click on adding a new vehicle then it will add the vehicle we have just entered to the array
     * and return us to fill in details about the new vehicle we would like to add
     * If we click on adding the vehicle and opening the agency, it will add the vehicle
     * we have just entered to the array of vehicles and open the agency window where there are pictures of all the vehicles in the agency
     * @param e the event to be processed
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {
            String s1=model.getText();
            String s2=move.getText();
            String s3=distance.getText();
            String s4=passengers.getText();
            String s5=speed.getText();
            String s9 = (String) cb3.getSelectedItem();


            int s=Integer.parseInt(s2);
            double a=Double.parseDouble(s3);
            int b=Integer.parseInt(s4);
            double c=Double.parseDouble(s5);

            ElectricBicycle temp1=new ElectricBicycle(f,s1,s,a,b,c,2,null,s9);
            //Car_Agency.add_Vehicle(temp1);
            System.out.println(temp1.toString());
            Car_Agency.print();
            Threads_class.get_Instance().addVehicle(this,temp1);


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



        } else if (e.getActionCommand().equals("<html>Adding and entering<br />a car dealership</html>")) {
            String s1=model.getText();
            String s2=move.getText();
            String s3=distance.getText();
            String s4=passengers.getText();
            String s5=speed.getText();
            String s9 = (String) cb3.getSelectedItem();


            int s=Integer.parseInt(s2);
            double a=Double.parseDouble(s3);
            int b=Integer.parseInt(s4);
            double c=Double.parseDouble(s5);

            ElectricBicycle temp1=new ElectricBicycle(f,s1,s,a,b,c,2,null,s9);
            //Car_Agency.add_Vehicle(temp1);

            System.out.println(temp1.toString());
            Car_Agency.print();
            Threads_class.get_Instance().addVehicle(this,temp1);



            Agency_Frame frame=new Agency_Frame(Threads_class.get_Instance().get_Vehicles());

            this.dispose();

        }
    }


}
