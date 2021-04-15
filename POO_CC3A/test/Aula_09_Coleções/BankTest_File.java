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
public class BankTest_File {
    
    @Test
    public void testeConstrutor() {
        Bank banco = new Bank("entrada.txt");
        assertNotNull(banco);
    }
    
    @Test
    public void testeAddAccount() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(5,banco.getAccounts().size());
        assertEquals(1011,banco.getAccounts().get(0).getAccountNumber());
    }
    
    @Test
    public void testeGetTotalBalance() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(8910.00, banco.getTotalBalance(),0.001);
        
    }
    @Test
    public void testeGetTotalBalance2() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(8910.00, banco.getTotalBalance2(),0.001);
        
    }
    @Test
    public void testeFind() {
        Bank banco = new Bank("entrada.txt");
        assertEquals("Renato Rodrigues", banco.find(2045).getOwner());
    }
    @Test
    public void testeGetMaximum() {
        Bank banco = new Bank("entrada.txt");
        assertEquals("Guilherme Freitas", banco.getMaximum().getOwner());
    }
    @Test
    public void testeCount() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(3, banco.count(900.0));
    }

}
