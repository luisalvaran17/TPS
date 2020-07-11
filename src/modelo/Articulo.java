/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luisalvaranleav
 */
@Entity
@Table(name = "articulo")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo"),
    @NamedQuery(name = "Articulo.findByNombreArticulo", query = "SELECT a FROM Articulo a WHERE a.nombreArticulo = :nombreArticulo"),
    @NamedQuery(name = "Articulo.findByPrecioArticulo", query = "SELECT a FROM Articulo a WHERE a.precioArticulo = :precioArticulo"),
    @NamedQuery(name = "Articulo.findByCantidadArticulo", query = "SELECT a FROM Articulo a WHERE a.cantidadArticulo = :cantidadArticulo")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArticulo")
    private Integer idArticulo;
    @Basic(optional = false)
    @Column(name = "nombreArticulo")
    private String nombreArticulo;
    @Basic(optional = false)
    @Column(name = "precioArticulo")
    private int precioArticulo;
    @Basic(optional = false)
    @Column(name = "cantidadArticulo")
    private int cantidadArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private Collection<Entrada> entradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private Collection<Salida> salidaCollection;

    public Articulo() {
    }

    public Articulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Integer idArticulo, String nombreArticulo, int precioArticulo, int cantidadArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
        this.cantidadArticulo = cantidadArticulo;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(int precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Collection<Entrada> getEntradaCollection() {
        return entradaCollection;
    }

    public void setEntradaCollection(Collection<Entrada> entradaCollection) {
        this.entradaCollection = entradaCollection;
    }

    public Collection<Salida> getSalidaCollection() {
        return salidaCollection;
    }

    public void setSalidaCollection(Collection<Salida> salidaCollection) {
        this.salidaCollection = salidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Articulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
