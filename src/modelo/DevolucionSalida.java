/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luisalvaranleav
 */
@Entity
@Table(name = "devolucion_salida")
@NamedQueries({
    @NamedQuery(name = "DevolucionSalida.findAll", query = "SELECT d FROM DevolucionSalida d"),
    @NamedQuery(name = "DevolucionSalida.findByIdDevolucionSalida", query = "SELECT d FROM DevolucionSalida d WHERE d.idDevolucionSalida = :idDevolucionSalida"),
    @NamedQuery(name = "DevolucionSalida.findByFechaDevSalida", query = "SELECT d FROM DevolucionSalida d WHERE d.fechaDevSalida = :fechaDevSalida"),
    @NamedQuery(name = "DevolucionSalida.findByCantidadDevSalida", query = "SELECT d FROM DevolucionSalida d WHERE d.cantidadDevSalida = :cantidadDevSalida")})
public class DevolucionSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDevolucionSalida")
    private Integer idDevolucionSalida;
    @Basic(optional = false)
    @Column(name = "fechaDevSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaDevSalida;
    @Basic(optional = false)
    @Column(name = "cantidadDevSalida")
    private int cantidadDevSalida;
    @JoinColumn(name = "idSalida", referencedColumnName = "idSalida")
    @ManyToOne(optional = false)
    private Salida idSalida;

    public DevolucionSalida() {
    }

    public DevolucionSalida(Integer idDevolucionSalida) {
        this.idDevolucionSalida = idDevolucionSalida;
    }

    public DevolucionSalida(Integer idDevolucionSalida, Date fechaDevSalida, int cantidadDevSalida) {
        this.idDevolucionSalida = idDevolucionSalida;
        this.fechaDevSalida = fechaDevSalida;
        this.cantidadDevSalida = cantidadDevSalida;
    }

    public Integer getIdDevolucionSalida() {
        return idDevolucionSalida;
    }

    public void setIdDevolucionSalida(Integer idDevolucionSalida) {
        this.idDevolucionSalida = idDevolucionSalida;
    }

    public Date getFechaDevSalida() {
        return fechaDevSalida;
    }

    public void setFechaDevSalida(Date fechaDevSalida) {
        this.fechaDevSalida = fechaDevSalida;
    }

    public int getCantidadDevSalida() {
        return cantidadDevSalida;
    }

    public void setCantidadDevSalida(int cantidadDevSalida) {
        this.cantidadDevSalida = cantidadDevSalida;
    }

    public Salida getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Salida idSalida) {
        this.idSalida = idSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevolucionSalida != null ? idDevolucionSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionSalida)) {
            return false;
        }
        DevolucionSalida other = (DevolucionSalida) object;
        if ((this.idDevolucionSalida == null && other.idDevolucionSalida != null) || (this.idDevolucionSalida != null && !this.idDevolucionSalida.equals(other.idDevolucionSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DevolucionSalida[ idDevolucionSalida=" + idDevolucionSalida + " ]";
    }
    
}
