package com.grupo7;

public class ContaCorrente {
    
    private String numeroConta;
    private String nomeCorrentista;
    private double saldo;
    private String categoria;
    
    public ContaCorrente(String numeroConta, String nomeCorrentista) {        
        this.numeroConta = numeroConta;
        this.nomeCorrentista = nomeCorrentista;
        saldo = 0;
        categoria = "Silver";        
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public boolean deposito(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            if (categoria.equals("Silver")) {
                saldo += valor;
                if (saldo >= 50000) {
                    categoria = "Gold";
                }
            } else {
                if (categoria.equals("Gold")) {
                    saldo += valor * 1.01;
                    if (saldo >= 200000) {
                        categoria = "Platinum";
                    }
                } else {
                    saldo += valor * 1.025;
                }
            }
        }
        return true;
    }
    
    public boolean retirada(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            if (saldo - valor < 0) {
                return false;
            } else {
                saldo = saldo - valor;
                if (categoria.equals("Platinum") && saldo < 100000) {
                    categoria = "Gold";
                } else {
                    if (categoria.equals("Gold") && saldo < 25000) {
                        categoria = "Silver";
                    }
                }
            }
        }
        return true;
    }
    
}