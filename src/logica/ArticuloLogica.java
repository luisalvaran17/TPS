/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Articulo;
import persistencia.ArticuloJpaController;

/**
 *
 * @author luisalvaranleavpc
 */
public class ArticuloLogica {

    private ArticuloJpaController articuloDAO = new ArticuloJpaController();

    /**
     * @param articulo
     * @throws Exception 
     */
    public final void registrarArticulo(Articulo articulo) throws Exception {
        if (articulo == null) {
            throw new Exception("Llene los campos");
        }
        if (articulo.getNombreArticulo() == null
                || articulo.getPrecioArticulo() <= 0
                || articulo.getCantidadArticulo() <= 0) {
            throw new Exception(
                    "Asegurese de completar los campos del formulario"
                    + " o de ingresar los valores correctos");
        }
        articuloDAO.create(articulo);
    }
}