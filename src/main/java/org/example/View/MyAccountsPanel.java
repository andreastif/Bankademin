package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class MyAccountsPanel extends JPanel {
    private Customer currentCustomer;
    private JLabel customerName = new JLabel();
    private JLabel accountName = new JLabel();
    private JLabel balance = new JLabel();

    public MyAccountsPanel(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        this.setLayout(new GridBagLayout());

        customerName.setText("Kund: " + currentCustomer.getName());
        accountName.setText("Konto: " + currentCustomer.getAccount().getAccountName());
        balance.setText("Saldo: " + currentCustomer.getAccount().getBalance());

        this.add(customerName);
        this.add(accountName);
        this.add(balance);
    }
}
