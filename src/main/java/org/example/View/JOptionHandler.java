package org.example.View;

import javax.swing.*;

public class JOptionHandler {

    // En dynamisk prompt i form av en JOptionpane som kan återanvändas med custom meddelande som man för in som param
    public String jOptionPrompt(String messageInPrompt) {
        while (true) {
            String result = JOptionPane.showInputDialog(messageInPrompt);
            if (result == null) {
                break;
            } else if (result.isBlank()) {
                JOptionPane.showMessageDialog(null, "Får ej va tomt!");
            } else {
                return result;
            }
        }
        return null; // Kasta nullpointerexception ?
    }

}


