/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JOptionPane;
import persistencia.DevolucionEntradaJpaController;
import modelo.DevolucionEntrada;

/**
 *
 * @author llStiven
 */
public class DevolucionEntradaLogica {

    /**
     * ***************************************************
     */
    public DevolucionEntradaJpaController devolucionEntradaDAO = new DevolucionEntradaJpaController();

    public void registrarDevolucion(DevolucionEntrada devEntrada) throws Exception {

        if (devEntrada == null) {
            throw new Exception("Llene los campos");
        }

        if (devEntrada.getIdEntrada() == null || devEntrada.getFechaDevEntrada() == null) {
            throw new Exception("Asegurese de completar los campos del formulario");
        }
        if (devEntrada.getCantidadDevEntrada() <= 0) { //tener en cuenta la cantidad de articulos disponibles
            throw new Exception("Asegurese de indicar una cantidad correcta");
        }
        devolucionEntradaDAO.create(devEntrada);
    }
    /**
     * ****************************************************
     */

}
