package org.example.Controller;

import org.example.Model.Account;
import org.example.Model.Customer;
import org.example.Model.ReadFile;
import org.example.Model.WriteFile;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void successfullTransferToOtherAccountTest() {

        Customer martin = new Customer("123","martin röv", "1", LocalDate.parse("1995-01-01"), new Account("martins konto", 5000));
        Customer ricardoMilos = new Customer("5566","ricardo milos", "1", LocalDate.parse("1993-11-15"), new Account("Ricardos konto", 5000));

        assertTrue(Controller.transferToOtherAccount(200,martin, ricardoMilos));
        assertEquals(4800, martin.getAccount().getBalance());
        assertEquals(5200, ricardoMilos.getAccount().getBalance());
        assertNotEquals(5200, martin.getAccount().getBalance());
        assertNotEquals(4800, ricardoMilos.getAccount().getBalance());
    }

    @Test
    void failTransferToOtherAccountTest() {

        Customer martin = new Customer("123","martin röv", "1", LocalDate.parse("1995-01-01"), new Account("martins konto", 0));
        Customer ricardoMilos = new Customer("123","ricardo milos", "1", LocalDate.parse("1993-11-15"), new Account("Ricardos konto", 5000));

        assertFalse(Controller.transferToOtherAccount(200,martin, ricardoMilos));
        assertEquals(0, martin.getAccount().getBalance());
        assertEquals(5000, ricardoMilos.getAccount().getBalance());
    }
}