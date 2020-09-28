package com.grupo7;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {
    private ContaCorrente OnPoint;
    private ContaCorrente OffPoint;

    @BeforeEach
    public void setup(){
        OnPoint = new ContaCorrente("0000", "Ryan");
        OffPoint = new ContaCorrente("0001", "Xandao");
    }

    @Test
    public void depositoValorNegativo() {        
        assertFalse(OffPoint.deposito(-50));
    }

    @Test
    public void depositoGold(){
        OnPoint.deposito(50519);
        OnPoint.deposito(148000); //199,999
        assertEquals(OnPoint.getCategoria(), "Gold");
        OnPoint.deposito(1); //200,000
        assertEquals(OnPoint.getCategoria(), "Platinum");

        OffPoint.deposito(199000);
        assertEquals(OffPoint.getCategoria(), "Gold");
        OffPoint.deposito(10000000);
        assertEquals(OffPoint.getCategoria(), "Platinum");
    }

    @Test
    public void retiradaSilver(){
        OnPoint.deposito(1000);
        OnPoint.retirada(1000);
        assertEquals(OnPoint.getCategoria(), "Silver");

        OffPoint.deposito(1000);
        OffPoint.retirada(525);
        assertEquals(OffPoint.getCategoria(), "Silver");
    }

    @Test
    public void retiradaGold(){
        OnPoint.deposito(50000);
        OnPoint.retirada(25000);
        assertEquals(OnPoint.getCategoria(), "Gold");
        OnPoint.retirada(1);
        assertEquals(OnPoint.getCategoria(), "Silver");

        OffPoint.deposito(100000);
        OffPoint.retirada(32656);
        assertEquals(OffPoint.getCategoria(), "Gold");
        OffPoint.retirada(67322);
        assertEquals(OffPoint.getCategoria(), "Silver");
    }

    @Test
    public void retiradaPlatinum(){
        OnPoint.deposito(50000);
        OnPoint.deposito(150000);//201,500
        OnPoint.retirada(101500);//100,000
        assertEquals(OnPoint.getCategoria(), "Platinum");
        OnPoint.retirada(1);//99,000
        assertEquals(OnPoint.getCategoria(), "Gold");

        OffPoint.deposito(50000);
        OffPoint.deposito(200000);
        OffPoint.retirada(45000);
        assertEquals(OffPoint.getCategoria(), "Platinum");
        OffPoint.retirada(180239);
        assertEquals(OffPoint.getCategoria(), "Gold");
    }
   


}