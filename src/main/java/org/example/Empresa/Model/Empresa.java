package org.example.Empresa.Model;

import org.example.Empresa.Exceptions.EmpresaAtributoNuloException;

public class Empresa {
    private Integer id;
    private String nombre;

    private Empresa(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Empresa factoryEmpresa(Integer id, String nombre) throws EmpresaAtributoNuloException {
        notNull(nombre, "El nombre no puede ser nulo");
        return new Empresa(id, nombre);
    }

    private static void notNull(Object object, String descripcion) throws EmpresaAtributoNuloException {
        if(object == null)
            throw new EmpresaAtributoNuloException(descripcion);
    }
    private static void notEmpty(String valor, String descripcion) throws EmpresaAtributoNuloException {
        if (valor.isEmpty())
            throw new EmpresaAtributoNuloException(descripcion);
    }
}
