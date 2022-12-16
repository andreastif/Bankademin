package org.example.Controller;

import org.example.Model.Customer;

import org.example.Model.ReadFile;
import org.example.Model.WriteFile;
import org.example.View.*;


import javax.swing.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

public class Controller {

    static ReadFile readFile = new ReadFile();
    static WriteFile writeFile = new WriteFile();
    static final Path customersFile = Path.of("src/main/resources/Customers.txt");
    public Controller(){
        new GuiFrame(new LoginPanel(), false);
    }

    public static Customer verifyLogin(String id, String password) throws NoSuchElementException {
        return readFile.createListFromFile(customersFile).stream()
                .filter(customer -> customer.getId().equalsIgnoreCase(id) && customer.getPassword().equals(password))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public static Customer getCustomerById(String id) throws NoSuchElementException {
        return readFile.createListFromFile(customersFile).stream()
                .filter(customer -> customer.getId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }


    // TODO - Prio 1, måste göras innan arbetet kan fortsätta
    public static String generateStringToTransactions(){
        // Här ska vi bygga strängen som ska skickas in till WriteFile. Det enda WriteFile ska göra är att skriva till filen.
        // Här bestämmer vi HUR den ska skriva till filen.

        String textPackage = sb.toString();

        writeFile.saveTransaction(textPackage);

    }

    // TODO - Nästan klar.
    public static boolean transferToOtherAccount(int amountToSend, Customer fromCustomer, Customer toCustomer) {

        //ta in textfilen Customers.txt - OK (görs innan, ej här)
        //validera id att skicka till - OK (görs innan, ej här)
        //validera att belopp finns på egna kontot - OK
        //skicka pengarna till andra kontot - OK
            //sänk balance hos fromCustomer - OK
            //öka balance hos toCustomer - OK
            //TODO Skriv till transaktionsLoggen från den som har skickat, hur mycket och till vem amountToSend och spara till en transaktionsLogg.txt - OK
            //return true - OK
        //return false om inte det går att skicka cash (fel toCustomer eller om insufficient funds etc) - OK
        if (validateFunds(fromCustomer, amountToSend)) {
            fromCustomer.getAccount().decreaseBalance(amountToSend);
            toCustomer.getAccount().increaseBalance(amountToSend);
            generateStringToTransactions(amountToSend, fromCustomer, toCustomer);
            return true;
        }
        return false;
    }

    public static boolean validateFunds(Customer customer, int amount) {
        return customer.getAccount().getBalance() - amount > 0;
    }

    // TODO - Denna kan göras efter att vi skriver korrekt till transaktionsloggen (metod generateStringToTransactions), då vet vi hur filen är formatterad och hur vi skall interagera med den.
    public static String findMyTransactions() {
        String transactionLog;
        // Använd currentCustomers ID som regex för att hitta alla rader i Transactions.txt som är kopplade till currentCustomer.
        // Bygg strängarna i StringBuilder
        // paketera och returnera strängen till JTextArean i vederbörande panel.
        return "";
    }


    public static void main(String[] args) {
        new Controller();
    }
}
