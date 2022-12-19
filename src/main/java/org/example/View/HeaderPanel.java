package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JButton buttonOne = new JButton("Hem");
    private JButton buttonTwo = new JButton("Mina konton");
    private JButton buttonThree = new JButton("Betala och överföra");
    private JButton buttonFour = new JButton("Kontakt");

    private boolean isLoggedIn;

    private Customer currentCustomer;


    public HeaderPanel(boolean isLoggedIn, Customer currentCustomer){
        this.currentCustomer = currentCustomer;
        this.isLoggedIn = isLoggedIn;
        this.setLayout(new GridBagLayout());

        loadMenu(isLoggedIn);

        this.setBackground(Color.decode("#4B56D2"));
        this.setPreferredSize(new Dimension(600, 100));
        addListeners();
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
            buttons[i].setBackground(Color.decode("#C0DEFF"));
            this.add(buttons[i]);
            this.add(Box.createHorizontalStrut(15));
        }
    }

    public void addListeners() {
        buttonOne.addActionListener(event -> {
            if(currentCustomer != null) {
                Container parent = getParent();
                parent.removeAll();
                parent.add(new HeaderPanel(true, currentCustomer), BorderLayout.NORTH);
                parent.add(new HomePanel(currentCustomer), BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            }
        });

        buttonTwo.addActionListener(event -> {
            if(currentCustomer != null) {
                Container parent = getParent();
                parent.removeAll();
                parent.add(new HeaderPanel(true, currentCustomer), BorderLayout.NORTH);
                parent.add(new MyAccountsPanel(currentCustomer), BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            }
        });

        buttonThree.addActionListener(event -> {
            if(currentCustomer != null) {
                Container parent = getParent();
                parent.removeAll();
                parent.add(new HeaderPanel(true, currentCustomer), BorderLayout.NORTH);
                parent.add(new TransferPanel(currentCustomer), BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            }
        });

        buttonFour.addActionListener(event -> {
            Container parent = getParent();
            parent.removeAll();
            parent.add(new HeaderPanel(true, currentCustomer), BorderLayout.NORTH);
            parent.add(new ContactPanel(currentCustomer), BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
        });
    }
}

