package org.example.Empresa.Model;

import org.example.Empresa.Exceptions.EmpresaException;

public class Empresa {
    private Integer id;
    private String nombre;

    private Empresa(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Empresa factoryEmpresa(Integer id, String nombre) throws EmpresaException {
        notEmpty(nombre, "El nombre no puede ser nulo");
        return new Empresa(id, nombre);
    }

    private static void notNull(Object object, String descripcion) throws EmpresaException {
        if(object == null)
            throw new EmpresaException(descripcion);
    }
    private static void notEmpty(String valor, String descripcion) throws EmpresaException {
        if (valor.isEmpty())
            throw new EmpresaException(descripcion);
    }

    public String getNombre() {
        return nombre;
    }
}
