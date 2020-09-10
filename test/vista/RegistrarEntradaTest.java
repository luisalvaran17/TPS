/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author luisalvaranleavpc
 */

public class RegistrarEntradaTest extends TestCase{
    
    public RegistrarEntradaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    @Test
    public void testCalcularCostoPonderado(){
        System.out.println("Calcular costo promedio ponderado");
        //10000, 5000, 5, 20
        //20000, 10000, 10, 25
        //32000, 15000, 50, 78
        RegistrarEntrada instance = new RegistrarEntrada();
        int precio = 0;
        int precioActual = 0;
        int cantidadArticulo = 0;
        int cantidadActual = 0;
        int valoresTest[][] = {{10000, 5000, 5, 20}, {20000, 10000, 10, 25}, {32000, 15000, 50, 78} };
        int resultadosTest[] = {6000, 12857, 21640};
        int expResult = 0;
        int result = 0; //instance.calcularCostoPonderado(precio, precioActual, cantidadArticulo, cantidadActual);
        
        for (int i = 0; i < valoresTest.length; i++) {
            for (int j = 0; j < 1; j++) {
                precio = valoresTest[i][j];
                precioActual = valoresTest[i][j+1];
                cantidadArticulo = valoresTest[i][j+2];
                cantidadActual = valoresTest[i][j+3];
            }
            result = instance.calcularCostoPonderado(precio, precioActual, cantidadArticulo, 
                    cantidadActual);
            expResult = resultadosTest[i];
            assertEquals(expResult, result);
            
            
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class RegistrarEntrada.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistrarEntrada.main(args);
        //RegistrarEntradaTest registrarEntradaTest = new RegistrarEntradaTest();
        //registrarEntradaTest.testCalcularCostoPonderado();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
