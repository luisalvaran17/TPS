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
public class RegistrarDevolucionSalidaTest extends TestCase{
    
    public RegistrarDevolucionSalidaTest() {
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
     * Test of actualizarSalida method, of class RegistrarDevolucionSalida.
     */
    @Test
    public void testActualizarSalida() {
        System.out.println("actualizarSalida");
        String idSalida = "4";
        int cantidadDev = 12;
        RegistrarDevolucionSalida instance = new RegistrarDevolucionSalida();
        instance.actualizarSalida(idSalida, cantidadDev);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class RegistrarDevolucionSalida.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistrarDevolucionSalida.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
