import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
public class WATT{
    public static void main(String[] args) throws IOException{
        //Make WATT window
        JFrame watt = new JFrame("Weather App of Terror and Trauma");
        watt.setLayout(new BorderLayout());
        watt.setSize(910,580);
        watt.setLocationRelativeTo(null);
        watt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        //add the Box of Happiness
        BoxOfHappiness box = new BoxOfHappiness();
        JPanel left= new JPanel(new BorderLayout());
        JPanel topLeft= new JPanel(new BorderLayout());
        JLabel text = new JLabel("Box of Happiness");
        text.setHorizontalAlignment(JLabel.CENTER); 
        String thing = box.generate(0,1);
        JLabel label= new JLabel(thing);
        label.setHorizontalAlignment(JLabel.CENTER); 
        topLeft.add(text,BorderLayout.NORTH);
        topLeft.add(label,BorderLayout.SOUTH);
        topLeft.setSize(200,200);
        topLeft.setBorder(new LineBorder(Color.BLACK, 1, true));
        topLeft.setOpaque(true); 
        topLeft.setBackground(Color.CYAN); 
        left.add(topLeft, BorderLayout.NORTH);
        
        watt.add(left,BorderLayout.WEST);
        watt.setVisible(true);

    } 
}