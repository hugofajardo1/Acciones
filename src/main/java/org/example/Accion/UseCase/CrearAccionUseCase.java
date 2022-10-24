package org.example.Accion.UseCase;

import org.example.Accion.Input.ICrearAccionInput;
import org.example.Accion.Model.Accion;
import org.example.Accion.Repository.ICrearAccionRepository;

public class CrearAccionUseCase implements ICrearAccionInput {

    ICrearAccionRepository crearAccionRepository;

    public CrearAccionUseCase(ICrearAccionRepository crearAccionRepository){
        this.crearAccionRepository = crearAccionRepository;
    }
    @Override
    public boolean crearAccion(Accion empresa) {
        return crearAccionRepository.guardar(empresa);
    }
}