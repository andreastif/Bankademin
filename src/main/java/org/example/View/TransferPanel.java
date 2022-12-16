package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {

    private Customer currentCustomer;
    private JButton sendAccBtn = new JButton("Överföring andra konton");
    private JButton payBillsBtn = new JButton("Betalning PG/BG");

    public TransferPanel(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        this.setLayout(new GridBagLayout());
        this.add(sendAccBtn);
        this.add(payBillsBtn);

        //TEST
        this.add(new JLabel(currentCustomer.getName()));
        
        addListeners();
    }

    private void addListeners() {
        sendAccBtn.addActionListener(event -> {
            if(currentCustomer != null) {
                int accountNr = (int) new JOptionHandler().transferPrompt("Ange konto nr");
                double amount = new JOptionHandler().transferPrompt("Ange belopp");

                System.out.println(accountNr);
                System.out.println(amount);
            }
        });

        payBillsBtn.addActionListener(event -> {
            if(currentCustomer != null) {
                String amount = new JOptionHandler().jOptionPrompt("Betalning PG/BG");
            }
        });
    }

}



