package org.example.Controller;

import org.example.Model.Customer;
import org.example.Model.FileReader;
import org.example.View.*;

import java.nio.file.Path;
import java.util.NoSuchElementException;

public class Controller {

    static FileReader fr = new FileReader();
    static final Path customersFile = Path.of("src/main/resources/Customers.txt");
    public Controller(){
        new GuiFrame(new LoginPanel(), false);
    }

    public static Customer verifyLogin(String id, String password) throws NoSuchElementException {
        return fr.createListFromFile(customersFile).stream()
                .filter(customer -> customer.getId().equalsIgnoreCase(id) && customer.getPassword().equals(password))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public static Customer getCustomerById(String id) throws NoSuchElementException {
        return fr.createListFromFile(customersFile).stream()
                .filter(customer -> customer.getId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }


    // TODO
    public static String generateStringToTransactions(){
        // Här ska vi bygga strängen som ska skickas in till FileWriter. Det enda FileWriter ska göra är att skriva till filen.
        // Här bestämmer vi HUR den ska skriva till filen.

        String completed = "";
        StringBuilder sb = new StringBuilder();

        return completed;
    }

    // TODO
    public static boolean transferToOtherAccount(int amountToSend, Customer toCustomer, Customer fromCustomer) {

        //ta in textfilen Customers.txt
        //validera id att skicka till
        //validera att belopp finns på egna kontot
            //skicka pengarna till andra kontot =
                //reducera det egna kontot
                //öka det andra kontot
                    //Om allt OK ->
                    //Skriv till transaktionsLoggen från den som har skickat, hur mycket och till vem amountToSend och spara till en transaktionsLogg.txt
                    //return true
        //return false om inte det går att skicka cash (fel toCustomer eller om insufficient funds etc)
        return false;

    }

    // TODO
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
