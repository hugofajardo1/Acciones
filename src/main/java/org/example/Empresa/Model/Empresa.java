package org.example.Empresa.Model;

public class Empresa {
    private Integer id;
    private String nombre;

    private Empresa(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Empresa factoryEmpresa(Integer id, String nombre) {
        return new Empresa(id, nombre);
    }
}
