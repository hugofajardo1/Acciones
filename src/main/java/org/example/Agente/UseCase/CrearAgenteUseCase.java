package org.example.Agente.UseCase;

import org.example.Agente.Input.ICrearAgenteInput;
import org.example.Agente.Model.Agente;
import org.example.Agente.Repository.ICrearAgenteRepository;
import org.example.Agente.Repository.IVerificarAgenteRepository;

public class CrearAgenteUseCase implements ICrearAgenteInput {

    ICrearAgenteRepository crearAgenteRepository;

    IVerificarAgenteRepository verificarAgenteRepository;
    public CrearAgenteUseCase(ICrearAgenteRepository crearAgenteRepository, IVerificarAgenteRepository verificarAgenteRepository){
        this.crearAgenteRepository = crearAgenteRepository;
        this.verificarAgenteRepository = verificarAgenteRepository;
    }
    @Override
    public boolean crearAgente(Agente empresa) {
        boolean retorno = false;
        if (!verificarAgenteRepository.existeAgente(empresa.getNombre()))
            retorno = crearAgenteRepository.guardar(empresa);
        return retorno;
    }
}
