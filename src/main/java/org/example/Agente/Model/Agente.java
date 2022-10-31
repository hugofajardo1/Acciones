package org.example.Agente.Model;

import org.example.Agente.Exceptions.AgenteException;
import org.example.Estrategia.Interface.IEstrategia;
import org.example.Estrategia.Model.EstrategiaA;

import java.util.ArrayList;

public class Agente {
    private Integer id;
    private String nombre;
    private double saldo;

    private ArrayList<IEstrategia> estrategias;

    private Agente(Integer id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        //Setea Estrategia Inicial
        this.estrategias.add(new EstrategiaA());
    }

    public static Agente factoryAgente(Integer id, String nombre, double saldo) throws AgenteException {
        notEmpty(nombre, "El nombre no puede ser nulo");
        return new Agente(id, nombre, saldo);
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

    public void AgregarEstrategia(IEstrategia estrategia){
        this.estrategias.add(estrategia);
    }
    public void EliminarEstrategia(IEstrategia estrategia){
        this.estrategias.remove(estrategia);
    }
}
