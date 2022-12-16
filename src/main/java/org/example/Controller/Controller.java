package org.example.Controller;

import org.example.Model.Customer;

import org.example.Model.ReadFile;
import org.example.Model.WriteFile;
import org.example.View.*;


import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

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

    public static void generateStringToTransactionLog(int amountToSend, Customer fromCustomer, Customer toCustomer){

        LocalDateTime ldt = LocalDateTime.now();
        String ldtFormatted = ldt.format(DateTimeFormatter.ofPattern("yy.MM.dd:HHmm")); // 221216:1530 (datum : klockslag)
        StringBuilder sb = new StringBuilder();

        sb
                .append(ldtFormatted)
                .append(", From ID: ")
                .append(fromCustomer.getId())
                .append(", ")
                .append(amountToSend)
                .append(" SEK")
                .append(", To ID: ")
                .append(toCustomer.getId())
                .append("\n");

        String textPackage = sb.toString();
        writeFile.saveTransactionToTransactionLog(textPackage);
    }

    public static void saveCustomerTransactionToCustomerTxt(int amount, Customer fromCustomer, Customer toCustomer) {

        //Vi har uppdaterat customer-objekten just nu. Bara spara till

        readFile.createListFromFile(customersFile).stream().map( e -> {

        });



//        writeFile.updateCustomerTxt();
    }

    public static boolean transferToOtherAccount(double amountToSend, Customer fromCustomer, Customer toCustomer) {

        //TODO: Uppdatera Customers.TXT med nytt SALDO?

        if (validateFunds(fromCustomer, amountToSend)) {
            fromCustomer.getAccount().decreaseBalance(amountToSend);
            toCustomer.getAccount().increaseBalance(amountToSend);
            generateStringToTransactionLog(amountToSend, fromCustomer, toCustomer); //sparar en logg till transactions.txt
            saveCustomerTransactionToCustomerTxt(amountToSend, fromCustomer, toCustomer); //uppdaterar customer.txt
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

    public static boolean isDouble(String number) {
        try{
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        new Controller();
    }
}
