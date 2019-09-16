/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "registrohuespedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrohuespedes.findAll", query = "SELECT r FROM Registrohuespedes r")
    , @NamedQuery(name = "Registrohuespedes.findByIdregistroHuespedes", query = "SELECT r FROM Registrohuespedes r WHERE r.idregistroHuespedes = :idregistroHuespedes")
    , @NamedQuery(name = "Registrohuespedes.findByFechaentrada", query = "SELECT r FROM Registrohuespedes r WHERE r.fechaentrada = :fechaentrada")
    , @NamedQuery(name = "Registrohuespedes.findByFechasalida", query = "SELECT r FROM Registrohuespedes r WHERE r.fechasalida = :fechasalida")
    , @NamedQuery(name = "Registrohuespedes.findByEstado", query = "SELECT r FROM Registrohuespedes r WHERE r.estado = :estado")
    , @NamedQuery(name = "Registrohuespedes.findByCantidadpersonas", query = "SELECT r FROM Registrohuespedes r WHERE r.cantidadpersonas = :cantidadpersonas")})
public class Registrohuespedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistroHuespedes")
    private Integer idregistroHuespedes;
    @Column(name = "fechaentrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrada;
    @Column(name = "fechasalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidadpersonas")
    private Integer cantidadpersonas;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idreserva", referencedColumnName = "idreserva")
    @ManyToOne
    private Reserva idreserva;

    public Registrohuespedes() {
    }

    public Registrohuespedes(Integer idregistroHuespedes) {
        this.idregistroHuespedes = idregistroHuespedes;
    }

    public Integer getIdregistroHuespedes() {
        return idregistroHuespedes;
    }

    public void setIdregistroHuespedes(Integer idregistroHuespedes) {
        this.idregistroHuespedes = idregistroHuespedes;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(Integer cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Reserva getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Reserva idreserva) {
        this.idreserva = idreserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistroHuespedes != null ? idregistroHuespedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrohuespedes)) {
            return false;
        }
        Registrohuespedes other = (Registrohuespedes) object;
        if ((this.idregistroHuespedes == null && other.idregistroHuespedes != null) || (this.idregistroHuespedes != null && !this.idregistroHuespedes.equals(other.idregistroHuespedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jasongatica.entities.Registrohuespedes[ idregistroHuespedes=" + idregistroHuespedes + " ]";
    }
    
}
