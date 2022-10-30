package org.example.Agente.Model;

import org.example.Agente.Exceptions.AgenteException;

public class Agente {
    private Integer id;
    private String nombre;

    private Agente(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Agente factoryAgente(Integer id, String nombre) throws AgenteException {
        notEmpty(nombre, "El nombre no puede ser nulo");
        return new Agente(id, nombre);
    }

    private static void notNull(Object object, String descripcion) throws AgenteException {
        if(object == null)
            throw new AgenteException(descripcion);
    }
    private static void notEmpty(String valor, String descripcion) throws AgenteException {
        if (valor.isEmpty())
            throw new AgenteException(descripcion);
    }

    public String getNombre() {
        return nombre;
    }
}
