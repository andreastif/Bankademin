package org.example.View;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JButton buttonOne = new JButton("Hem");
    private JButton buttonTwo = new JButton("Mina konton");
    private JButton buttonThree = new JButton("Betala och överföra");
    private JButton buttonFour = new JButton("Kontakt");

    private boolean isLoggedIn;


    public HeaderPanel(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
        this.setLayout(new GridBagLayout());

        loadMenu(isLoggedIn);

        this.setBackground(Color.decode("#C7F2A4"));
        this.setPreferredSize(new Dimension(600, 100));
    }

    public void loadMenu(boolean isLoggedIn) {
        if(isLoggedIn) {
            JButton[] buttons = {buttonOne, buttonTwo, buttonThree, buttonFour};
            loadButtons(buttons);
        } else {
            JLabel header = new JLabel("Welcome to Bankademin");
            header.setFont(new Font("Sans-serif", Font.BOLD, 30));
            this.add(header);
        }
    }

    public void loadButtons(JButton[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(new Font("Sans-serif", Font.BOLD, 25));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.decode("#E9EFC0"));
            this.add(buttons[i]);
            this.add(Box.createHorizontalStrut(15));
        }
    }
}

