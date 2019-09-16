/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva")
    , @NamedQuery(name = "Reserva.findByFechaingreso", query = "SELECT r FROM Reserva r WHERE r.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "Reserva.findByFechaegreso", query = "SELECT r FROM Reserva r WHERE r.fechaegreso = :fechaegreso")
    , @NamedQuery(name = "Reserva.findByCantidadpersonas", query = "SELECT r FROM Reserva r WHERE r.cantidadpersonas = :cantidadpersonas")
    , @NamedQuery(name = "Reserva.findByComentario", query = "SELECT r FROM Reserva r WHERE r.comentario = :comentario")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreserva")
    private Integer idreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaegreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaegreso;
    @Column(name = "cantidadpersonas")
    private Integer cantidadpersonas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "comentario")
    private String comentario;
    @OneToMany(mappedBy = "idreserva")
    private List<Registrohuespedes> registrohuespedesList;
    @JoinColumn(name = "idTipohabitacion", referencedColumnName = "idtipohabitacion")
    @ManyToOne
    private Tipohabitacion idTipohabitacion;

    public Reserva() {
    }

    public Reserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Reserva(Integer idreserva, Date fechaingreso, Date fechaegreso, String comentario) {
        this.idreserva = idreserva;
        this.fechaingreso = fechaingreso;
        this.fechaegreso = fechaegreso;
        this.comentario = comentario;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechaegreso() {
        return fechaegreso;
    }

    public void setFechaegreso(Date fechaegreso) {
        this.fechaegreso = fechaegreso;
    }

    public Integer getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(Integer cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public List<Registrohuespedes> getRegistrohuespedesList() {
        return registrohuespedesList;
    }

    public void setRegistrohuespedesList(List<Registrohuespedes> registrohuespedesList) {
        this.registrohuespedesList = registrohuespedesList;
    }

    public Tipohabitacion getIdTipohabitacion() {
        return idTipohabitacion;
    }

    public void setIdTipohabitacion(Tipohabitacion idTipohabitacion) {
        this.idTipohabitacion = idTipohabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jasongatica.entities.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
