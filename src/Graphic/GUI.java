package Graphic;

import javax.swing.*;

public class GUI {
    public static void main(String[] args){
        JFrame frame=new JFrame("Car Agency");
        frame.add(new JButton("Adding vehicles"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
