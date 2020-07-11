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
@Table(name = "salida")
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findByIdSalida", query = "SELECT s FROM Salida s WHERE s.idSalida = :idSalida"),
    @NamedQuery(name = "Salida.findByFechaSalida", query = "SELECT s FROM Salida s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Salida.findByCantidadArticulo", query = "SELECT s FROM Salida s WHERE s.cantidadArticulo = :cantidadArticulo")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalida")
    private Integer idSalida;
    @Basic(optional = false)
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "cantidadArticulo")
    private int cantidadArticulo;
    @JoinColumn(name = "idArticulo", referencedColumnName = "idArticulo")
    @ManyToOne(optional = false)
    private Articulo idArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalida")
    private Collection<DevolucionSalida> devolucionSalidaCollection;

    public Salida() {
    }

    public Salida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Salida(Integer idSalida, Date fechaSalida, int cantidadArticulo) {
        this.idSalida = idSalida;
        this.fechaSalida = fechaSalida;
        this.cantidadArticulo = cantidadArticulo;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Collection<DevolucionSalida> getDevolucionSalidaCollection() {
        return devolucionSalidaCollection;
    }

    public void setDevolucionSalidaCollection(Collection<DevolucionSalida> devolucionSalidaCollection) {
        this.devolucionSalidaCollection = devolucionSalidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalida != null ? idSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.idSalida == null && other.idSalida != null) || (this.idSalida != null && !this.idSalida.equals(other.idSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Salida[ idSalida=" + idSalida + " ]";
    }
    
}
