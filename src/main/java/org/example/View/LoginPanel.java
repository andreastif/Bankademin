package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel{

    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();

    private JButton loginBtn = new JButton("Login");

    private JLabel header = new JLabel("Please enter your credentials");

    public LoginPanel() {
        this.setLayout(new GridBagLayout());
        username.setText("Enter Username");
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
            // Kolla om username && password stämmer i db sedan logga in.
            if(username.getText().equalsIgnoreCase("admin") && password.getText().equalsIgnoreCase("password")) {
                Container parent = getParent();
                parent.removeAll();
                parent.add(new Header(true), BorderLayout.NORTH);
                parent.add(new HomePanel(), BorderLayout.CENTER);
                parent.revalidate();
                parent.repaint();
            } else {
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
