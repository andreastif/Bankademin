package org.example.View;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JTextArea textArea = new JTextArea(52, 78);

    public HomePanel(){
        textArea.setText("\nVälkommen till Bankademins nya internetbank! wihoooooo");

        textArea.setEditable(false);

        this.setBackground(Color.WHITE);

        this.add(textArea);
    }

}
