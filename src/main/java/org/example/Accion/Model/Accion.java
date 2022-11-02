package org.example.Accion.Model;

import org.example.Accion.Exceptions.AccionException;
import org.example.Empresa.Model.Empresa;

import java.time.LocalDate;

public class Accion {
    private final Integer id;
    private final Empresa empresa;
    private final LocalDate fecha;
    private final Double precio;
    private final Integer cantidad;

    public Empresa getEmpresa() {
        return empresa;
    }

    private Accion(Integer id, Empresa empresa, LocalDate fecha, Double precio, Integer cantidad) {
        this.id = id;
        this.empresa = empresa;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public static Accion factoryAccion(Integer id, Empresa empresa, LocalDate fecha, Double precio, Integer cantidad) throws AccionException {
        notNull(fecha, "La Fecha no puede ser nulo");
        verificarNoNegativo(precio);
        verificarNoNegativo(cantidad);

        return new Accion(id, empresa, fecha, precio, cantidad);
    }

    private static void notNull(Object object, String descripcion) throws AccionException {
        if(object == null)
            throw new AccionException(descripcion);
    }

    private static void verificarNoNegativo(Integer cantidad) throws AccionException {
        if(cantidad <= 0)
            throw new AccionException("La cantidad debe ser mayor a cero");
    }
    private static void verificarNoNegativo(Double cantidad) throws AccionException {
        if(cantidad <= 0)
            throw new AccionException("El precio debe ser mayor a cero");
    }
}