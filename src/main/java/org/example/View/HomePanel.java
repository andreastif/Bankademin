package org.example.View;

import org.example.Model.Customer;
import org.example.Controller.*;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JTextArea textArea = new JTextArea();

    private Customer currentCustomer;

    private boolean adminMode;

    public HomePanel(Customer currentCustomer, boolean adminMode){
        this.currentCustomer = currentCustomer;
        this.adminMode = adminMode;
        loadContent();
    }

    public void loadContent() {
        String newsReelAddition = Controller.getNewsReelText();
        String user;
        if (adminMode) {
            user = "Du är inloggad som Admin.\n";
        } else {
            user = currentCustomer.getName() + ".\n";
        }
        String newsReel = "Välkommen till Bankademins tillfälliga internettjänst.\n" +
                "Tyvärr ligger våran ordinarie sida nere just nu. Vissa tjänster är inte tillgängliga. Vi jobbar på felet\n\n" +
                "Senaste information från BANKADEMIN: \n\n" +
                newsReelAddition;

        textArea.setText(user + newsReel);
        textArea.setFont(new Font("Sans-serif", Font.BOLD, 20));
        textArea.setEditable(false);
        this.setBackground(Color.WHITE);
        this.add(textArea);
    }

}