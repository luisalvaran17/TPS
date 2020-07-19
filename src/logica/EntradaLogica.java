/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Entrada;
import persistencia.EntradaJpaController;

/**
 *
 * @author miime
 */
public class EntradaLogica {
     
    public EntradaJpaController entradaDAO = new EntradaJpaController();
    
    public void registrar (Entrada entrada) throws Exception{
    
        if (entrada == null){
            throw new Exception("Por favor, llene los campos");
        }
        
        if (entrada.getIdArticulo() == null || entrada.getCantidadArticulo() == 0 ){
            
            throw new Exception("Asegúrese de completar los campos del formulario");
        }
        
        entradaDAO.create(entrada);
    }
    
}
