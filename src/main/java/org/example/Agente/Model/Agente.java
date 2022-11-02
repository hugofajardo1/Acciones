package org.example.Agente.Model;

import org.example.Accion.Exceptions.AccionException;
import org.example.Accion.Model.Accion;
import org.example.Agente.Exceptions.AgenteException;
import org.example.Empresa.Model.Empresa;
import org.example.Estrategia.Interface.IEstrategia;
import org.example.Estrategia.Model.EstrategiaA;

import java.time.LocalDate;
import java.util.ArrayList;

public class Agente {
    private Integer id;
    private String nombre;
    private double saldo;
    private ArrayList<IEstrategia> estrategias;
    private ArrayList<Accion> accionesCompradas;
    private ArrayList<Accion> accionesVendidas;

    private Agente(Integer id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        //Setea Estrategia Inicial
        this.estrategias.add(new EstrategiaA());
        this.accionesCompradas = new ArrayList<Accion>();
        this.accionesVendidas = new ArrayList<Accion>();
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
    public void EvaluarEstrategias(){
        this.estrategias.forEach((estrategia) -> estrategia.evaluar(this));
    }
    public Accion Comprar(Empresa empresa, Integer cantidad, Double precio) throws AccionException {
        Accion accion = Accion.factoryAccion(0, empresa, LocalDate.now(), precio, cantidad);
        this.accionesCompradas.add(accion);
        this.saldo = this.saldo - (precio * cantidad);
        return accion;
    }
    public Accion Vender(Empresa empresa, Integer cantidad, Double precio) throws AccionException {
        Accion accion = Accion.factoryAccion(0, empresa, LocalDate.now(), precio, cantidad);
        this.accionesVendidas.add(accion);
        this.saldo = this.saldo + (precio * cantidad);
        return accion;
    }
}
