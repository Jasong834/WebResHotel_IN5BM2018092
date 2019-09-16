/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.sessionbeans;

import com.jasongatica.entities.Registrohuespedes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class RegistrohuespedesFacade extends AbstractFacade<Registrohuespedes> implements RegistrohuespedesFacadeLocal {

    @PersistenceContext(unitName = "WebResHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrohuespedesFacade() {
        super(Registrohuespedes.class);
    }
    
}
