package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JTextArea textArea = new JTextArea(52, 78);

    private Customer currentCustomer;

    public HomePanel(Customer currentCustomer){
        this.currentCustomer = currentCustomer;
        textArea.setText("\n" + currentCustomer.getName() + "\n" + "Välkommen till Bankademins nya internetbank! wihoooooo");

        textArea.setEditable(false);

        this.setBackground(Color.WHITE);

        this.add(textArea);
    }

}
