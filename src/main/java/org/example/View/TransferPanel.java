package org.example.View;

import org.example.Controller.Controller;
import org.example.Model.Customer;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;

public class TransferPanel extends JPanel {

    private Customer currentCustomer;
    private JButton sendAccBtn = new JButton("Överföring andra konton");
    private JButton payBillsBtn = new JButton("Betalning PG/BG");

    private JLabel accountNumberLabel = new JLabel("Konto: ");
    private JTextField accountNumber = new JTextField("                     ");
    private JLabel amountLabel = new JLabel("Belopp: ");
    private JTextField amount = new JTextField("                     ");
    private JButton sendBtn = new JButton("Skicka");

    public TransferPanel(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        this.setLayout(new GridBagLayout());

        this.add(sendAccBtn);
        this.add(payBillsBtn);

        //TEST
        this.add(new JLabel(currentCustomer.getName()));

        addMouseListeners();
        addEventListeners();
    }

    private void addMouseListeners() {
        accountNumber.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                accountNumber.setText("");
            }
        });

        amount.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                amount.setText("");
            }
        });
    }

    private void addEventListeners() {
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

        sendBtn.addActionListener(event -> {
            String accountFormatted = accountNumber.getText().trim();
            String amountFormatted = amount.getText().trim();

            if(accountFormatted.isBlank() || amountFormatted.isBlank()) {
                JOptionPane.showMessageDialog(null, "Du måste fylla i båda fälten!");
            } else if (accountFormatted.equalsIgnoreCase(currentCustomer.getAccount().getAccountNumber())) {
                JOptionPane.showMessageDialog(null,"Du kan inte överföra pengar till ditt egna konto!");
            } else if (amountFormatted.contains("-")){
                JOptionPane.showMessageDialog(null,"Ange giltigt belopp! Inte minus");
            } else if (!(Controller.isDouble(amountFormatted))) {
                JOptionPane.showMessageDialog(null,"Bara siffror tack!");
            } else {
                handleTransfer(accountFormatted, Double.parseDouble(amountFormatted));
            }
        });

        payBillsBtn.addActionListener(event -> {
            System.out.println("Hej hej pay bills");
        });
    }

    private void handleTransfer(String account, double amount) {
        try {
            Customer receiver = Controller.getCustomerByAccountNr(account);
            boolean greatSuccess = Controller.transferToOtherAccount(amount, currentCustomer, receiver);
            if(greatSuccess) {
                JOptionPane.showMessageDialog(null, "Skickade " + amount + " Kr till Konto: " + account);
            } else {
                JOptionPane.showMessageDialog(null, "Du har ej tillräckligt med pengar på kontot, du har: " + currentCustomer.getAccount().getBalance() + " Kr");
            }
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "Konto nr finns ej");
        }

    }


}



