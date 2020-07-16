/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Salida;
import persistencia.SalidaJpaController;

/**
 *
 * @author Personal
 */
public class salidaLogica {
    
    public SalidaJpaController salidaDAO = new SalidaJpaController();
    
    
    public void registrar (Salida salida) throws Exception{
    
        if (salida == null){
            throw new Exception("Llene los campos");
        }
        
        if (salida.getIdArticulo() == null || salida.getCantidadArticulo() == 0 || salida.getFechaSalida() == null ){
            
            throw new Exception("Asegurese de completar los campos del formulario");
        }
        
        salidaDAO.create(salida);
    }
    
}
