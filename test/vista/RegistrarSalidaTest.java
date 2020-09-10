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
public class RegistrarSalidaTest extends TestCase{
    
    public RegistrarSalidaTest() {
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
     * Test of actualizarArticulo method, of class RegistrarSalida.
     */
    @Test
    public void testActualizarArticulo() {
        System.out.println("actualizarArticulo");
        String idArticulo = "1";
        int cantSale = 100;
        RegistrarSalida instance = new RegistrarSalida();
        instance.actualizarArticulo(idArticulo, cantSale);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class RegistrarSalida.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistrarSalida.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
