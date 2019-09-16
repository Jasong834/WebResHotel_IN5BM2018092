/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.sessionbeans;

import com.jasongatica.entities.Tipohabitacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class TipohabitacionFacade extends AbstractFacade<Tipohabitacion> implements TipohabitacionFacadeLocal {

    @PersistenceContext(unitName = "WebResHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipohabitacionFacade() {
        super(Tipohabitacion.class);
    }
    
}
