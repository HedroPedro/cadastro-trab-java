/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pedro Olveira
 */
public class BuscadorTest {
    private Buscador buscador;
    
    public BuscadorTest() {
        buscador = new Buscador();
    }

    @Test
    public void onGettingCEPValuesThrowException() {
        assertThrows(new IllegalArgumentException().getClass(), () -> {
            buscador.buscar("77-88");
        });
    }
    
    @Test
    public void onGettingCEPValuesAssertCidade(){
        String expectedCidade = "Bandeirantes";
        String actualCidade = "";
        try{
            actualCidade = buscador.buscar("86360-000").getCidade();
        } catch (IOException ex) {
            Logger.getLogger(BuscadorTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BuscadorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expectedCidade, actualCidade);
    }
}
