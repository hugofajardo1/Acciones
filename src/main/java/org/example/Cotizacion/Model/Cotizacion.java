package org.example.Cotizacion.Model;

import org.example.Cotizacion.Exceptions.CotizacionAtributoNuloException;
import org.example.Empresa.Model.Empresa;

import java.time.LocalDate;

public class Cotizacion {
    private final Integer id;
    private final Empresa empresa;
    private final LocalDate fecha;
    private final double precio;

    private Cotizacion(Integer id, Empresa empresa, LocalDate fecha, double precio) {
        this.id = id;
        this.empresa = empresa;
        this.fecha = fecha;
        this.precio = precio;
    }

    public static Cotizacion factoryCotizacion(Integer id, Empresa empresa, LocalDate fecha, double precio) throws CotizacionAtributoNuloException {
        notNull(empresa, "Empresa no puede ser nulo");
        notNull(fecha, "La fecha no puede ser nula");
        return new Cotizacion(id, empresa, fecha, precio);
    }

    private static void notNull(Object object, String descripcion) throws CotizacionAtributoNuloException {
        if(object == null)
            throw new CotizacionAtributoNuloException(descripcion);
    }
    private static void notEmpty(String valor, String descripcion) throws CotizacionAtributoNuloException {
        if (valor.isEmpty())
            throw new CotizacionAtributoNuloException(descripcion);
    }
}
