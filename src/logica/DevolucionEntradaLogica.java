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
    
    public void actualizarUnidades(DevolucionEntrada devEntrada) throws Exception {

    }

    public void registrarDevolucion(DevolucionEntrada devEntrada) throws Exception {

        try {
            if (devEntrada == null) {
                System.out.println("1");
                throw new Exception("Debe llenar los campos");
            } else {
                if (devEntrada.getIdEntrada() == null) {
                    System.out.println("2");
                    throw new Exception("Debe indicar el número del pedido");

                } else {
                    System.out.println("3");
                    if (devEntrada.getIdEntrada().getIdEntrada() <= 0 || devEntrada.getIdEntrada().getIdEntrada() <= 0) {
                        throw new Exception("Ingrese un ID o número de órden válido");
                    } else {
                        devolucionEntradaDAO.create(devEntrada);
                        actualizarUnidades(devEntrada);
                        JOptionPane.showMessageDialog(null, "Devolucion registrada exitosamente");
                    }
                }
            }

        } catch (Exception e) {
        }

    }
    /**
     * ****************************************************
     */
}
