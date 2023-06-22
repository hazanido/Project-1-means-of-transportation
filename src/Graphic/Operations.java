package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import Decorator.carStatus;
import Graphic.Memento.memento;
import Vehicle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class represents a GUI window for performing operations on a Vehicle object.
 * The class extends JFrame and implements ActionListener interface.
 * It contains buttons for test driving a vehicle, buying a vehicle, changing flag and resetting all the vehicles data.
 */


public class Operations extends JFrame implements ChangeListener {

    private Vehicle vehicle;
    private int i;
    private JButton test_drive, buying_car, Flag_change, Reset, Current_Inventory_Report, Exit,save,charging;
    private List<Vehicle> vehicles;
    private BufferedImage b_Operations_photo;
    private ImageIcon i_Operations_photo;
    private float generalDistance = 0;
    public final static int TEST_DRIVE_COUNT=7;
    private int count_test=0;

    /**
     * Constructor for the Operations class. Initializes instance variables and sets up the GUI window.
     *
     * @param i        The index of the vehicle in the array of vehicles passed to the constructor.
     * @param vehicles An array of Vehicle objects.
     */

    public Operations(int i, List<Vehicle> vehicles) {
        this.i = i;
        this.vehicles=vehicles;

        // Set window properties
        this.setVisible(true);
        this.setSize(415, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Operations");
        categories();


    }

    private void Buy(int index) {
        if (Threads_class.get_Instance().Inspection_by_index(index)) {
            JOptionPane.showMessageDialog(null, "Vehicle type is current in test - please try again later");
            return;
        }
        try {
            System.out.println("Sleeping" );
            Thread.sleep( 1000);
        } catch (Exception ignored) {
        }
        int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Threads_class.get_Instance().removeVehicle(this,index);
            float totalDistance = Threads_class.get_Instance().get_Total_Distance();
            main_window.updateTotalDistance(totalDistance);
            Buying_car frame=new Buying_car(index,vehicles);
            frame.setVisible(true);
        }

    }
    private void categories(){
        java.util.List<Vehicle> vehicles = Threads_class.get_Instance().get_Vehicles();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setOpaque(false);
        this.add(panel);

        try {
            b_Operations_photo = ImageIO.read(new File("src/Graphic/pictures/Operations.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        i_Operations_photo = new ImageIcon(b_Operations_photo);
        JLabel backgroundLabel = new JLabel(i_Operations_photo);

        backgroundLabel.setBounds(0, 0, i_Operations_photo.getIconWidth(), i_Operations_photo.getIconHeight());
        this.getContentPane().add(backgroundLabel);
        this.add(backgroundLabel);


        test_drive = new JButton("Test drive");
        buying_car = new JButton("Buying car");
        Flag_change = new JButton("Flag change");
        Current_Inventory_Report = new JButton("<html>Current Inventory<br />Report</html>");
        save = new JButton("Save");
        charging = new JButton("Charging");
        Reset = new JButton("Reset All");
        Exit = new JButton("Exit");


        test_drive.setBounds(40, 40, 150, 60);

        panel.add(test_drive);
        test_drive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carStatus.changeStatus("test drive");
                System.out.println(vehicles.toString());
                ExecutorService pool= Executors.newFixedThreadPool(TEST_DRIVE_COUNT);
                if (!Threads_class.get_Instance().Inspection_by_type(i)) {
                    count_test++;

                    if(count_test<=TEST_DRIVE_COUNT){
                        pool.execute(new Test_drive(i,vehicles));
                        //Test_drive testDrive = new Test_drive(i, vehicles);
                        //testDrive.setVisible(true);

                    }
                }
                else {
                    try {
                        throw new IllegalStateException("This vehicle is currently being test driven. Please try again later.");
                    } catch (IllegalStateException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                pool.shutdown();
            }
        });

        buying_car.setBounds(210, 40, 150, 60);
        panel.add(buying_car);
        buying_car.addActionListener(e -> Buy(i));


        Flag_change.setBounds(40, 120, 150, 60);
        panel.add(Flag_change);
        Flag_change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag_selection flag = new Flag_selection(i, vehicles);
                flag.setVisible(true);
            }
        });

        Current_Inventory_Report.setBounds(210, 120, 150, 60);
        panel.add(Current_Inventory_Report);
        Current_Inventory_Report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory_Report frame = new Inventory_Report();
                frame.setVisible(true);

            }
        });
        Reset.setBounds(5, 240, 90, 30);
        panel.add(Reset);

        Reset.addActionListener(e -> Threads_class.get_Instance().resetAll(this));

        charging.setBounds(105,240,90,30);
        panel.add(charging);
        charging.addActionListener(e-> {
            if(memento.getInstance().restore()) {
                repaint();
            }
        });
        save.setBounds(205,240,90,30);
        panel.add(save);
        save.addActionListener(e-> {
            memento.getInstance().save(vehicles);
            //System.out.println(memento.getInstance().getClass().toString());
        });

        Exit.setBounds(305, 240, 90, 30);
        panel.add(Exit);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Threads_class.get_Instance().InProgress()) {
                    JOptionPane.showMessageDialog(null, "Unable to log out because the program is still in progress - try again later");
                }
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                System.gc();
                System.exit(0);
            }
        });



    }
    public void change_listener(){

        test_drive.removeAll();
        buying_car.removeAll();
        Flag_change.removeAll();
        Reset.removeAll();
        Exit.removeAll();
        categories();


        test_drive.revalidate();
        test_drive.repaint();

        buying_car.revalidate();
        buying_car.repaint();

        Flag_change.revalidate();
        Flag_change.repaint();

        Reset.revalidate();
        Reset.repaint();

        Exit.revalidate();
        Exit.repaint();
        invalidate();
        validate();
        repaint();
    }
}





