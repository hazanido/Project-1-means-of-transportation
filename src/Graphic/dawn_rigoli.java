package Graphic;
import Vehicle.Car_Agency;
import Vehicle.Dawn_Rigoli;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class dawn_rigoli extends JFrame implements ActionListener {
    private JTextField model,move,distance,passengers,speed;
    private JButton add,add_and_closs;
    public dawn_rigoli (){
        this.setVisible(true);
        this.setSize(300, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Type Vehicle");
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
        JLabel lebal5 = new JLabel("Please type the type military/civilian?:");
        lebal5.setBounds(35, 290, 250, 20);
        this.add(lebal5);
        JRadioButton military = new JRadioButton("military");
        JRadioButton civilian = new JRadioButton("civilian");
        military.setBounds(40,310,70,20);
        civilian.setBounds(180,310,70,20);
        this.add(model);
        this.add(move);
        this.add(distance);
        this.add(passengers);
        this.add(speed);
        this.add(military);
        this.add(civilian);
        add=new JButton();
        add.setText("<html>Adding a<br />new vehicle</html>");
        add.setBounds(15,360,110,70);
        add.addActionListener(this);
        this.add(add);
        add_and_closs=new JButton("<html>Adding and entering<br />a car dealership</html>");
        add_and_closs.setBounds(155,360,120,70);
        this.add(add_and_closs);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<html>Adding a<br />new vehicle</html>")) {

            //Dawn_Rigoli temp1 = new Dawn_Rigoli(m, move, d, p, s, t);
            //Car_Agency.add_Vehicle(temp1);

            Type_Vehicle temp = new Type_Vehicle();
            this.dispose();
        }


    }
}
