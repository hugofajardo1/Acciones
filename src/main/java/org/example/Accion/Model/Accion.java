package org.example.Accion.Model;

import org.example.Accion.Exceptions.AccionException;

import java.time.LocalDate;

public class Accion {
    private Integer id;
    private LocalDate fecha;
    private Double precio;

    private Integer cantidad;

    private Accion(Integer id, LocalDate fecha, Double precio, Integer cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public static Accion factoryAccion(Integer id, LocalDate fecha, Double precio, Integer cantidad) throws AccionException {
        notNull(fecha, "La Fecha no puede ser nulo");
        verificarNoNegativo(precio);
        verificarNoNegativo(cantidad);

        return new Accion(id, fecha, precio, cantidad);
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