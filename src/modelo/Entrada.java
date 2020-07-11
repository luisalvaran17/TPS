/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luisalvaranleav
 */
@Entity
@Table(name = "entrada")
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByIdEntrada", query = "SELECT e FROM Entrada e WHERE e.idEntrada = :idEntrada"),
    @NamedQuery(name = "Entrada.findByFechaEtrada", query = "SELECT e FROM Entrada e WHERE e.fechaEtrada = :fechaEtrada"),
    @NamedQuery(name = "Entrada.findByCantidadArticulo", query = "SELECT e FROM Entrada e WHERE e.cantidadArticulo = :cantidadArticulo")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntrada")
    private Integer idEntrada;
    @Basic(optional = false)
    @Column(name = "fechaEtrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEtrada;
    @Basic(optional = false)
    @Column(name = "cantidadArticulo")
    private int cantidadArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrada")
    private Collection<DevolucionEntrada> devolucionEntradaCollection;
    @JoinColumn(name = "idArticulo", referencedColumnName = "idArticulo")
    @ManyToOne(optional = false)
    private Articulo idArticulo;

    public Entrada() {
    }

    public Entrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Entrada(Integer idEntrada, Date fechaEtrada, int cantidadArticulo) {
        this.idEntrada = idEntrada;
        this.fechaEtrada = fechaEtrada;
        this.cantidadArticulo = cantidadArticulo;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Date getFechaEtrada() {
        return fechaEtrada;
    }

    public void setFechaEtrada(Date fechaEtrada) {
        this.fechaEtrada = fechaEtrada;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Collection<DevolucionEntrada> getDevolucionEntradaCollection() {
        return devolucionEntradaCollection;
    }

    public void setDevolucionEntradaCollection(Collection<DevolucionEntrada> devolucionEntradaCollection) {
        this.devolucionEntradaCollection = devolucionEntradaCollection;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entrada[ idEntrada=" + idEntrada + " ]";
    }
    
}
