/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasongatica.sessionbeans;

import com.jasongatica.entities.Tipohabitacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface TipohabitacionFacadeLocal {

    void create(Tipohabitacion tipohabitacion);

    void edit(Tipohabitacion tipohabitacion);

    void remove(Tipohabitacion tipohabitacion);

    Tipohabitacion find(Object id);

    List<Tipohabitacion> findAll();

    List<Tipohabitacion> findRange(int[] range);

    int count();
    
}
