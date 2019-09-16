package com.jasongatica.entities;

import com.jasongatica.entities.Cliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-16T09:11:07")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Integer> idpago;
    public static volatile SingularAttribute<Pago, String> concepto;
    public static volatile SingularAttribute<Pago, Date> fechasalida;
    public static volatile SingularAttribute<Pago, Cliente> idcliente;

}