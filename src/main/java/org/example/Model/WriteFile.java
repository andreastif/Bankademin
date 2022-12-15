package org.example.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFile {
    public void saveTransaction(String transaction) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(Path.of("src/main/resources/Transactions.txt").toFile(), true))) {
            out.write(transaction);
        } catch (IOException e) {
            System.out.println("Inläsning av fil misslyckades. Säkerställ att Path är korrekt.");
        }
    }
}

