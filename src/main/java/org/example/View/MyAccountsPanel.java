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
        customerName.setFont(new Font("Sans-serif", Font.BOLD, 25));

        accountName.setText("Konto: " + currentCustomer.getAccount().getAccountName());
        accountName.setFont(new Font("Sans-serif", Font.BOLD, 25));

        balance.setText("Saldo: " + currentCustomer.getAccount().getBalance());
        balance.setFont(new Font("Sans-serif", Font.BOLD, 25));

        this.add(customerName);
        this.add(Box.createHorizontalStrut(15));
        this.add(accountName);
        this.add(Box.createHorizontalStrut(15));
        this.add(balance);

        // TODO gör TextArea ist för Labels + ScrollPane, Ta reda på korrekt ROWS och COLS
        // TODO: När MyAccounts öppnas så sätts texten i textarean till att bara visa personkontot med saldot.
        // TODO: När man klickar på kontot sätts texten i textarean till transaktionshistoriken.
    }
}
