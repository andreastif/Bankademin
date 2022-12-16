package org.example.View;

import org.example.Model.Customer;

import javax.naming.ldap.Control;
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
            accountNumber.setFont(new Font("Sans-serif", Font.BOLD, 25));
            accountNumberLabel.setFont(new Font("Sans-serif", Font.BOLD, 25));
            this.add(accountNumberLabel);
            this.add(accountNumber);
            this.add(Box.createHorizontalStrut(15));

            amount.setFont(new Font("Sans-serif", Font.BOLD, 25));
            amountLabel.setFont(new Font("Sans-serif", Font.BOLD, 25));
            this.add(amountLabel);
            this.add(amount);
            this.add(Box.createHorizontalStrut(15));

            sendBtn.setFont(new Font("Sans-serif", Font.BOLD, 25));
            this.add(sendBtn);

            this.remove(sendAccBtn);
            this.remove(payBillsBtn);
            this.revalidate();
            this.repaint();
        });

        payBillsBtn.addActionListener(event -> {
            if(currentCustomer != null) {
                String amount = new JOptionHandler().jOptionPrompt("Betalning PG/BG");
            }
        });
    }

}



