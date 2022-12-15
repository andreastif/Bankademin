package org.example.View;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    private JButton buttonOne = new JButton("Hem");
    private JButton buttonTwo = new JButton("Mina konton");
    private JButton buttonThree = new JButton("Betala och överföra");
    private JButton buttonFour = new JButton("Kontakt");


    public Header(){
        this.setLayout(new GridBagLayout());
        this.add(buttonOne);
        this.add(Box.createHorizontalStrut(15));
        this.add(buttonTwo);
        this.add(Box.createHorizontalStrut(15));
        this.add(buttonThree);
        this.add(Box.createHorizontalStrut(15));
        this.add(buttonFour);

        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(600, 100));
    }


}
