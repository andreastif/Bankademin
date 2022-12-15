package org.example.View;

import org.example.Controller.Controller;
import org.example.Model.Account;
import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Month;
import java.util.NoSuchElementException;

public class LoginPanel extends JPanel {

    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();

    private JButton loginBtn = new JButton("Login");

    private JLabel header = new JLabel("Please enter your credentials");

    public LoginPanel() {
        this.setLayout(new GridBagLayout());
        username.setText("Please Enter id");
        password.setText("Password123");

        username.setFont(new Font("Sans-serif", Font.BOLD, 22));
        password.setFont(new Font("Sans-serif", Font.BOLD, 22));
        header.setFont(new Font("Sans-serif", Font.BOLD, 25));

        loginBtn.setFont(new Font("Sans-serif", Font.BOLD, 25));
        loginBtn.setFocusable(false);
        loginBtn.setBackground(Color.decode("#E9EFC0"));

        this.add(header);
        this.add(Box.createHorizontalStrut(15));
        this.add(username);
        this.add(Box.createHorizontalStrut(15));
        this.add(password);
        this.add(Box.createHorizontalStrut(15));
        this.add(loginBtn);

        addListeners();
    }

    public void addListeners() {
        loginBtn.addActionListener(event -> {
            try {
                Customer currentCustomer = Controller.verifyLogin(username.getText(), password.getText());
                Container parent = getParent();
                parent.removeAll();
                parent.add(new HeaderPanel(true), BorderLayout.NORTH);
                parent.add(new HomePanel(currentCustomer), BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null, "Wrong username or password!");
            }
        });


        username.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                username.setText("");
            }
        });

        password.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                password.setText("");
            }
        });
    }
}
