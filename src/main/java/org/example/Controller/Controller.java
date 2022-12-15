package org.example.Controller;

import org.example.Model.Customer;
import org.example.Model.FileReader;
import org.example.View.*;

import java.nio.file.Path;
import java.util.List;

public class Controller {

    FileReader fr = new FileReader();
    final Path customersFile = Path.of("src/main/resources/Customers.txt");

    private List<Customer> customersList = fr.createListFromFile(customersFile);

    private GuiFrame guiFrame;
    private LoginPanel loginPanel;
    public Controller(){
        loginPanel = new LoginPanel();
        guiFrame = new GuiFrame(loginPanel, false);
        System.out.println(customersList);
    }


    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}
