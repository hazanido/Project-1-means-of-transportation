package Graphic;
import Vehicle.Car_Agency;
import Vehicle.Dawn_Rigoli;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class dawn_rigoli extends JFrame implements ActionListener {
    private JTextField move,distance;
    private JButton add,add_and_closs;
    public dawn_rigoli (){
        this.setVisible(true);
        this.setSize(300, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Dawn rigoli");
        JLabel lebal = new JLabel("model:");
        lebal.setBounds(70, 40, 150, 20);
        this.add(lebal);
        String model[]={"privileged"};
        JComboBox cb5=new JComboBox(model);
        cb5.setBounds(110,40,90,20);
        this.add(cb5);
        JLabel lebal1 = new JLabel("move:");
        lebal1.setBounds(70, 70, 150, 20);
        this.add(lebal1);
        move=new JTextField();
        move.setBounds(70,90,150,20);
        move.setToolTipText("please enter ability to move the vehicle");
        JLabel lebal2 = new JLabel("distance:");
        lebal2.setBounds(70, 120, 150, 20);
        this.add(lebal2);
        distance=new JTextField();
        distance.setBounds(70,140,150,20);
        distance.setToolTipText("please enter the distance the vehicle traveled during its lifetime");
        JLabel lebal3 = new JLabel("Max passengers:");
        lebal3.setBounds(70, 170, 150, 20);
        this.add(lebal3);
        String passengers[]={"1"};
        JComboBox cb6=new JComboBox(passengers);
        cb6.setBounds(180,170,50,20);
        this.add(cb6);

        JLabel lebal4 = new JLabel("speed:");
        lebal4.setBounds(70, 200, 150, 20);
        this.add(lebal4);
        String speed[]={"50km"};
        JComboBox cb4=new JComboBox(speed);
        cb4.setBounds(110,200,90,20);
        this.add(cb4);


        JLabel lebal5 = new JLabel("Please type the type military/civilian?");
        lebal5.setBounds(60, 230, 250, 20);
        this.add(lebal5);
        JRadioButton military = new JRadioButton("military");
        military.setBounds(110,250,70,20);

        JLabel lebal6 = new JLabel("Please select an energy score:");
        lebal6.setBounds(70, 270, 250, 40);
        this.add(lebal6);
        String Score[]={"C"};
        JComboBox cb1=new JComboBox(Score);
        cb1.setBounds(90,310,120,20);
        this.add(cb1);

        JLabel lebal7 = new JLabel("Please select the power source:");
        lebal7.setBounds(70, 330, 250, 40);
        this.add(lebal7);
        JRadioButton manual = new JRadioButton("manual");
        JRadioButton electric = new JRadioButton("electric");
        manual.setBounds(30,370,90,20);
        electric.setBounds(160,370,90,20);

        this.add(move);
        this.add(distance);
        this.add(military);

        this.add(manual);
        this.add(electric);
        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,420,110,50);
        add.addActionListener(this);
        this.add(add);
        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,420,120,50);
        this.add(add_and_closs);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {

            //Dawn_Rigoli temp1 = new Dawn_Rigoli("privileged",move,distance, 1, 50, "military");
            //Car_Agency.add_Vehicle(temp1);

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        }


    }
}
