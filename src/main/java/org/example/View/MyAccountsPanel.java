package org.example.View;

import org.example.Controller.Controller;
import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class MyAccountsPanel extends JPanel {
    private Customer currentCustomer;
    private JLabel customerName = new JLabel();
    private JButton accountName = new JButton();
    private JLabel balance = new JLabel();
    private JButton transactionsButton = new JButton("Transaktionshistorik");
    private JTextArea transactions = new JTextArea(25, 40);
    private JScrollPane scrollpain = new JScrollPane(transactions);


    public MyAccountsPanel(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;

        customerName.setText("Kund: " + currentCustomer.getName());
        customerName.setFont(new Font("Sans-serif", Font.BOLD, 25));

        accountName.setText("Konto: " + currentCustomer.getAccount().getAccountNumber());
        accountName.setFont(new Font("Sans-serif", Font.BOLD, 25));
        accountName.setBackground(Color.decode("#C0DEFF"));
        accountName.setFocusable(false);

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

        accountName.addActionListener(listener -> {
            List<String> allTrans = Controller.findMyTransactions(currentCustomer);
            String content = getTransLines(allTrans);

            transactions.setFont(new Font("Sans-serif", Font.BOLD, 22));
            transactions.setText(content);
            transactions.setEditable(false);
            transactions.setBorder(null);
            this.add(scrollpain, BorderLayout.SOUTH);
            this.revalidate();
            this.repaint();
        });


    }
}
