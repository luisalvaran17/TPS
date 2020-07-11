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
@Table(name = "devolucion_entrada")
@NamedQueries({
    @NamedQuery(name = "DevolucionEntrada.findAll", query = "SELECT d FROM DevolucionEntrada d"),
    @NamedQuery(name = "DevolucionEntrada.findByIdDevolucionEntrada", query = "SELECT d FROM DevolucionEntrada d WHERE d.idDevolucionEntrada = :idDevolucionEntrada"),
    @NamedQuery(name = "DevolucionEntrada.findByFechaDevEntrada", query = "SELECT d FROM DevolucionEntrada d WHERE d.fechaDevEntrada = :fechaDevEntrada"),
    @NamedQuery(name = "DevolucionEntrada.findByCantidadDevEntrada", query = "SELECT d FROM DevolucionEntrada d WHERE d.cantidadDevEntrada = :cantidadDevEntrada")})
public class DevolucionEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDevolucionEntrada")
    private Integer idDevolucionEntrada;
    @Basic(optional = false)
    @Column(name = "fechaDevEntrada")
    @Temporal(TemporalType.DATE)
    private Date fechaDevEntrada;
    @Basic(optional = false)
    @Column(name = "cantidadDevEntrada")
    private int cantidadDevEntrada;
    @JoinColumn(name = "idEntrada", referencedColumnName = "idEntrada")
    @ManyToOne(optional = false)
    private Entrada idEntrada;

    public DevolucionEntrada() {
    }

    public DevolucionEntrada(Integer idDevolucionEntrada) {
        this.idDevolucionEntrada = idDevolucionEntrada;
    }

    public DevolucionEntrada(Integer idDevolucionEntrada, Date fechaDevEntrada, int cantidadDevEntrada) {
        this.idDevolucionEntrada = idDevolucionEntrada;
        this.fechaDevEntrada = fechaDevEntrada;
        this.cantidadDevEntrada = cantidadDevEntrada;
    }

    public Integer getIdDevolucionEntrada() {
        return idDevolucionEntrada;
    }

    public void setIdDevolucionEntrada(Integer idDevolucionEntrada) {
        this.idDevolucionEntrada = idDevolucionEntrada;
    }

    public Date getFechaDevEntrada() {
        return fechaDevEntrada;
    }

    public void setFechaDevEntrada(Date fechaDevEntrada) {
        this.fechaDevEntrada = fechaDevEntrada;
    }

    public int getCantidadDevEntrada() {
        return cantidadDevEntrada;
    }

    public void setCantidadDevEntrada(int cantidadDevEntrada) {
        this.cantidadDevEntrada = cantidadDevEntrada;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevolucionEntrada != null ? idDevolucionEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionEntrada)) {
            return false;
        }
        DevolucionEntrada other = (DevolucionEntrada) object;
        if ((this.idDevolucionEntrada == null && other.idDevolucionEntrada != null) || (this.idDevolucionEntrada != null && !this.idDevolucionEntrada.equals(other.idDevolucionEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DevolucionEntrada[ idDevolucionEntrada=" + idDevolucionEntrada + " ]";
    }
    
}
