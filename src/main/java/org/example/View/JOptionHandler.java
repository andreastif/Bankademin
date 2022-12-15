package org.example.View;

import javax.swing.*;

public class JOptionHandler {

    // En dynamisk prompt i form av en JOptionpane som kan återanvändas med custom meddelande som man för in som param
    public String prompt(String messageInPrompt) {
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
        return null;
    }

    // TEST, FUNKAR, FÅR EJ VA TOMT + OM MAN KLICKAR CANCEL ELLER X så blir de ba NULL, man får göra en NULLCHECK
    public static void main(String[] args) {
        String test = new JOptionHandler().prompt("Test");
        System.out.println(test);
    }
}
