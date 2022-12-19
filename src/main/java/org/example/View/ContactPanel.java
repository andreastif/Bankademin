package org.example.View;

import org.example.Model.Customer;

import javax.swing.*;
import java.awt.*;

public class ContactPanel extends JPanel {

    private JTextArea textArea = new JTextArea(20, 20);
    private Customer currentCustomer;

    private StringBuilder sb = new StringBuilder();
    private String contactInfoHeader;
    private String contactInfoBody;
    private String aboutHeader;
    private String aboutBody;

    public ContactPanel(Customer currentCustomer){
        this.currentCustomer = currentCustomer;

        contactInfoHeader = "Kontaktinformation:\n";
        contactInfoBody = "Telefon: 072-209 14 10\n" +
                "Email: Bankademin.support@livesupport.india\n" +
                "Adress: Tomtebodavägen Tomtebodavägen 3A, 171 65 Solna\n\n";

        aboutHeader = "Vi är Bankademins ledningsgrupp:\n";
        aboutBody =
                "Hatte Von Strohlwasser\n" +
                        "Hatte har varit verksam i bankväsendet sedan 1978.\n" +
                        "Hatte blev medlem i ledningsgruppen och delägare till Bankdemin 1995 efter att han personligen\n" +
                        "räddade landet från Bank-, finans- och fastighetskrisen 1990.\n\n"  +
                "Ikaros Tass\n" +
                        "Född 2004. Jakob är med råge inte bara vår yngsta medlem i ledningsgruppen,\n" +
                        "utan också den yngsta personen på hela företaget.\n\n" +
                "Karl Hamilton\n" +
                        "REDACTED\n\n" +
                "Otto SilverHielm\n" +
                        "Otto var ordförande för studentkåren på den prestigefyllda internatskolan Solbacka.\n" +
                        "Otto brukar beskrivas av sina kollegor och vänner som ondskefull, sadistisk och hänsynslös.\n" +
                        "Ottos fritidsintressen sträcker sig från allt kring våld och lidande till olaga hot och bajskastning.";


        textArea.append(contactInfoHeader);
        textArea.append(contactInfoBody);
        textArea.append(aboutHeader);
        textArea.append(aboutBody);

        textArea.setFont(new Font("Sans-serif", Font.BOLD, 22));
        this.add(textArea);
        textArea.setEditable(false);


        this.setBackground(Color.WHITE);
    }

}
