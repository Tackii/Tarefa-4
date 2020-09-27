package com.grupo7;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {
    private ContaCorrente contaCorrente;

    @BeforeEach
    public void setup(){
        contaCorrente = new ContaCorrente("0000", "Ryan");
    }

    @Test
    public void depositoValorNegativo() {        
        assertFalse(contaCorrente.deposito(-50));
    }
   


}