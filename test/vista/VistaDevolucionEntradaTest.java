/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luisalvaranleavpc
 */
public class VistaDevolucionEntradaTest extends TestCase{
    
    public VistaDevolucionEntradaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actualizarEntrada method, of class VistaDevolucionEntrada.
     */
    @Test
    public void testActualizarEntrada() {
        System.out.println("actualizarEntrada");
        String idEntrada = "5";
        int cantidadDev = 62;
        VistaDevolucionEntrada instance = new VistaDevolucionEntrada();
        instance.actualizarEntrada(idEntrada, cantidadDev);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class VistaDevolucionEntrada.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VistaDevolucionEntrada.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
