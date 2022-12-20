package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JTextArea textArea = new JTextArea();

    private Customer currentCustomer;

    public HomePanel(Customer currentCustomer){
        this.currentCustomer = currentCustomer;
        textArea.setFont(new Font("Sans-serif", Font.BOLD, 20));
        textArea.setText("\nVälkommen till Bankademins tillfälliga internettjänst.\n" +
                "Tyvärr ligger våran ordinarie sida nere just nu. Vissa tjänster är inte tillgängliga. Vi jobbar på felet");
        textArea.setEditable(false);

        this.setBackground(Color.WHITE);

        this.add(textArea);
    }

}
