package org.ExampleTest.EmpresaTest.UseCaseTest;

import org.example.Empresa.Exceptions.EmpresaAtributoNuloException;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.example.Empresa.Repository.ICrearEmpresaRepository;
import org.example.Empresa.Repository.IVerificarEmpresaRepository;
import org.example.Empresa.UseCase.CrearEmpresaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class EmpresaCrearUseCaseTest {
    @Mock
    ICrearEmpresaRepository crearEmpresaRepository;

    @Mock
    IVerificarEmpresaRepository verificarEmpresaRepository;

    @Test
    public void crearEmpresa_EmpresaNoExiste_GuardaCorrectamente () throws EmpresaException, EmpresaAtributoNuloException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        when(crearEmpresaRepository.guardar(empresa)).thenReturn(true);
        CrearEmpresaUseCase crearEmpresaUseCase = new CrearEmpresaUseCase(crearEmpresaRepository, verificarEmpresaRepository);
        boolean resultado = crearEmpresaUseCase.crearEmpresa(empresa);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearEmpresa_EmpresaExiste_NoGuarda () throws EmpresaException, EmpresaAtributoNuloException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        when(verificarEmpresaRepository.existeEmpresa(empresa.getNombre())).thenReturn(true);
        when(crearEmpresaRepository.guardar(empresa)).thenReturn(true);
        CrearEmpresaUseCase crearEmpresaUseCase = new CrearEmpresaUseCase(crearEmpresaRepository, verificarEmpresaRepository);
        boolean resultado = crearEmpresaUseCase.crearEmpresa(empresa);
        Assertions.assertFalse(resultado);
    }
}
