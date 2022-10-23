package org.example.Cotizacion.Model;

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

    public static Cotizacion factoryCotizacion(Integer id, Empresa empresa, LocalDate fecha) {
        return new Cotizacion(id, empresa, fecha);
    }
}
