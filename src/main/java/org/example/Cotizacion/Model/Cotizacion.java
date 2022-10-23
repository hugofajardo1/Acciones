package org.example.Cotizacion.Model;

import org.example.Cotizacion.Exceptions.CotizacionAtributoNuloException;
import org.example.Cotizacion.Exceptions.CotizacionException;
import org.example.Empresa.Model.Empresa;

import java.time.LocalDate;

public class Cotizacion {
    private Integer id;
    private Empresa empresa;
    private LocalDate fecha;

    private Cotizacion(Integer id, Empresa empresa, LocalDate fecha) {
        this.id = id;
        this.empresa = empresa;
        this.fecha = fecha;
    }

    public static Cotizacion factoryCotizacion(Integer id, Empresa empresa, LocalDate fecha) throws CotizacionAtributoNuloException {
        notNull(empresa, "Empresa no puede ser nulo");
        notNull(fecha, "La fecha no puede ser nula");
        return new Cotizacion(id, empresa, fecha);
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
