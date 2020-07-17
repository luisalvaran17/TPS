/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import persistencia.DevolucionSalidaJpaController;
import modelo.DevolucionSalida;

/**
 *
 * @author luisalvaranleavpc
 */
public class DevolucionSalidaLogica {
    
    public DevolucionSalidaJpaController devolucionSalidaDAO = new DevolucionSalidaJpaController();
    
    public void registrarDevolucion(DevolucionSalida devSalida) throws Exception{
        
        if(devSalida == null){
            throw new Exception("Llene los campos");
        }
        
        if (devSalida.getIdSalida() == null || devSalida.getFechaDevSalida() == null){
            throw new Exception("Asegurese de completar los campos del formulario");
        }
        if (devSalida.getCantidadDevSalida() <= 0) { //tener en cuenta la cantidad de articulos disponibles
            throw new Exception("Asegurese de indicar una cantidad correcta");
        }
        devolucionSalidaDAO.create(devSalida);
    }
    
}
