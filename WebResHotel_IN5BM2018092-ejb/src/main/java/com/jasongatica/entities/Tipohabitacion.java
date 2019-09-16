/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "tipohabitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipohabitacion.findAll", query = "SELECT t FROM Tipohabitacion t")
    , @NamedQuery(name = "Tipohabitacion.findByIdtipohabitacion", query = "SELECT t FROM Tipohabitacion t WHERE t.idtipohabitacion = :idtipohabitacion")
    , @NamedQuery(name = "Tipohabitacion.findByDescripcion", query = "SELECT t FROM Tipohabitacion t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipohabitacion.findByNohabitacion", query = "SELECT t FROM Tipohabitacion t WHERE t.nohabitacion = :nohabitacion")
    , @NamedQuery(name = "Tipohabitacion.findByPrecio", query = "SELECT t FROM Tipohabitacion t WHERE t.precio = :precio")
    , @NamedQuery(name = "Tipohabitacion.findByNumeropiso", query = "SELECT t FROM Tipohabitacion t WHERE t.numeropiso = :numeropiso")
    , @NamedQuery(name = "Tipohabitacion.findByNopersonas", query = "SELECT t FROM Tipohabitacion t WHERE t.nopersonas = :nopersonas")})
public class Tipohabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipohabitacion")
    private Integer idtipohabitacion;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nohabitacion")
    private Integer nohabitacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "numeropiso")
    private Integer numeropiso;
    @Column(name = "nopersonas")
    private Integer nopersonas;
    @OneToMany(mappedBy = "idTipohabitacion")
    private List<Reserva> reservaList;

    public Tipohabitacion() {
    }

    public Tipohabitacion(Integer idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    public Integer getIdtipohabitacion() {
        return idtipohabitacion;
    }

    public void setIdtipohabitacion(Integer idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNohabitacion() {
        return nohabitacion;
    }

    public void setNohabitacion(Integer nohabitacion) {
        this.nohabitacion = nohabitacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getNumeropiso() {
        return numeropiso;
    }

    public void setNumeropiso(Integer numeropiso) {
        this.numeropiso = numeropiso;
    }

    public Integer getNopersonas() {
        return nopersonas;
    }

    public void setNopersonas(Integer nopersonas) {
        this.nopersonas = nopersonas;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipohabitacion != null ? idtipohabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipohabitacion)) {
            return false;
        }
        Tipohabitacion other = (Tipohabitacion) object;
        if ((this.idtipohabitacion == null && other.idtipohabitacion != null) || (this.idtipohabitacion != null && !this.idtipohabitacion.equals(other.idtipohabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jasongatica.entities.Tipohabitacion[ idtipohabitacion=" + idtipohabitacion + " ]";
    }
    
}
