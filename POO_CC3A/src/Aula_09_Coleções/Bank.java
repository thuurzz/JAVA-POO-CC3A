/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_09_Coleções;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anacris
 */
public class Bank {
    private ArrayList<BankAccount> accounts; //vetor de contas
    
    public Bank(){
        accounts = new ArrayList<>(); //criando um vetor dinâmico indexado     
    }
    public Bank(String filename){
        accounts = new ArrayList<>(); //criando um vetor dinâmico indexado 
        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));
            String linha = r.readLine();
            int n = Integer.parseInt(linha);
            String linhas[] = new String[n];
            for (int i=0; i < n; i++){
                linha = r.readLine();
                linhas = linha.split("#");
                BankAccount conta = new BankAccount(
                              Integer.parseInt(linhas[0]),
                              linhas[1],
                              linhas[2],
                              Double.parseDouble(linhas[3]));
                this.addAccount(conta);    
            }
            r.close();
       
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addAccount(BankAccount bankAccount) {
       //Insere uma conta no vetor de contas
        accounts.add(bankAccount); //insere no final
        
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    //Calcular o saldo total de todas as contas inseridas no banco
    public double getTotalBalance() {
       double soma=0.0;
       for(int i=0; i < accounts.size(); i++){
           BankAccount conta = accounts.get(i);
           soma = soma + conta.getBalance();
       }
       return soma;
    }
    //Calcular o saldo total de todas as contas inseridas no banco
    public double getTotalBalance2() {
       double soma=0.0;
       for(BankAccount conta: accounts){
           soma = soma + conta.getBalance();
       }
       return soma;
    }
    
    //Devolve a conta vinculada a um número dado
    public BankAccount find(int accountNumber) {
        for(BankAccount conta: accounts)
            if(conta.getAccountNumber() == accountNumber)
                return conta; //Achei
        return null;//Não achei
    }
    //Devolve a conta com o maior saldo
    public BankAccount getMaximum() {
        BankAccount maior = accounts.get(0);
        for(int i=1; i < accounts.size(); i++)
            if(accounts.get(i).getBalance() > maior.getBalance())
                maior = accounts.get(i); 
        return maior;
    }
    //Devolve a conta com o maior saldo
    public BankAccount getMaximum2() {
        BankAccount maior = accounts.get(0);
        for(BankAccount conta: accounts) //percorre tudo, desde a posição 0
            if(conta.getBalance() > maior.getBalance())
                maior = conta; 
        return maior;
    }
    //Devolve o número de contas com saldo igual ou superior a um limite
    public int count(double limit){
        int cont=0;
        for(BankAccount conta: accounts)
            if(conta.getBalance() >= limit)
                cont++; 
        return cont;
    }
    
}
