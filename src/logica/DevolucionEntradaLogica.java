/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import persistencia.DevolucionEntradaJpaController;
import modelo.DevolucionEntrada;

/**
 *
 * @author llStiven
 */
public class DevolucionEntradaLogica {
    
    /******************************************************/
    public DevolucionEntradaJpaController devolucionEntradaDAO = new DevolucionEntradaJpaController();
    
    public void registrarDevolucion (DevolucionEntrada devEntrada) throws Exception {
        
        if (devEntrada == null) {
            throw new Exception("Debe llenar los campos");
        }
        
        if (devEntrada.getIdEntrada() == null) {
            throw new Exception ("Debe indicar el número del pedido");
        }
        
        devolucionEntradaDAO.create(devEntrada);
    }
    /*******************************************************/
}
