package org.example.Empresa.UseCase;

import org.example.Empresa.Input.ICrearEmpresaInput;
import org.example.Empresa.Model.Empresa;
import org.example.Empresa.Repository.ICrearEmpresaRepository;
import org.example.Empresa.Repository.IVerificarEmpresaRepository;

public class CrearEmpresaUseCase implements ICrearEmpresaInput {

    ICrearEmpresaRepository crearEmpresaRepository;

    IVerificarEmpresaRepository verificarEmpresaRepository;
    public CrearEmpresaUseCase(ICrearEmpresaRepository crearEmpresaRepository, IVerificarEmpresaRepository verificarEmpresaRepository){
        this.crearEmpresaRepository = crearEmpresaRepository;
        this.verificarEmpresaRepository = verificarEmpresaRepository;
    }
    @Override
    public boolean crearEmpresa(Empresa empresa) {
        boolean retorno = false;
        if (!verificarEmpresaRepository.existeEmpresa(empresa.getNombre()))
            retorno = crearEmpresaRepository.guardar(empresa);
        return retorno;
    }
}
