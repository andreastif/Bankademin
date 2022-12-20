package org.example.View;


import org.example.Controller.Controller;
import org.example.Model.WriteFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;


public class AdminPanel extends JPanel {

    private JButton setTextBtn = new JButton("Uppdatera texten på hem-menyn");
    private JTextArea adminInputArea = new JTextArea(20, 40);
    private JScrollPane scrollPane = new JScrollPane(adminInputArea);




    public AdminPanel() {
        this.setLayout(new FlowLayout());
        adminInputArea.append("Skriv in en text för att uppdatera på hem-menyn");
        this.add(scrollPane);
        this.add(setTextBtn);

        addListeners();
    }

    public void addListeners() {
        setTextBtn.addActionListener(event -> {
            Controller.writeToHomeTxt(adminInputArea.getText());
        });
        adminInputArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                adminInputArea.setText("");
            }
        });
    }
}