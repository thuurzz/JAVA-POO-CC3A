/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_09_Coleções;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class BankTest {
    
    @Test
    public void testeConstrutor() {
        Bank banco = new Bank();
        assertNotNull(banco);
    }
    @Test
    public void testeAddAccount() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        assertEquals(1,banco.getAccounts().size());
        assertEquals(123,banco.getAccounts().get(0).getAccountNumber());
    }
    @Test
    public void testeGetTotalBalance() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        banco.addAccount(new BankAccount(145,"999","Maria Clara",480.0));
        banco.addAccount(new BankAccount(179,"555","Lucas Lima",120.0));
        double start = System.currentTimeMillis();
        assertEquals(1100.00, banco.getTotalBalance(),0.001);
        double elapsed = System.currentTimeMillis() - start;
        System.out.printf("tempo com índice = %.10f", elapsed);
    }
    @Test
    public void testeGetTotalBalance2() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        banco.addAccount(new BankAccount(145,"999","Maria Clara",480.0));
        banco.addAccount(new BankAccount(179,"555","Lucas Lima",120.0));
        double start = System.currentTimeMillis();
        assertEquals(1100.00, banco.getTotalBalance2(),0.001);
        double elapsed = System.currentTimeMillis() - start;
        System.out.printf("tempo iterator = %.10f", elapsed);
    }
    @Test
    public void testeFind() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        banco.addAccount(new BankAccount(145,"999","Maria Clara",480.0));
        banco.addAccount(new BankAccount(179,"555","Lucas Lima",120.0));
        assertEquals("Maria Clara", banco.find(145).getOwner());
    }
    @Test
    public void testeGetMaximum() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        banco.addAccount(new BankAccount(145,"999","Maria Clara",480.0));
        banco.addAccount(new BankAccount(179,"555","Lucas Lima",120.0));
        assertEquals("Marcos Roberto", banco.getMaximum().getOwner());
    }
    @Test
    public void testeCount() {
        Bank banco = new Bank();
        banco.addAccount(new BankAccount(123,"567","Marcos Roberto",500.0));
        banco.addAccount(new BankAccount(145,"999","Maria Clara",480.0));
        banco.addAccount(new BankAccount(179,"555","Lucas Lima",120.0));
        assertEquals(2, banco.count(400.0));
    }
}
