package org.ExampleTest.AccionTest.UseCaseTest;

import org.example.Accion.Exceptions.AccionException;
import org.example.Accion.Model.Accion;
import org.example.Accion.Repository.ICrearAccionRepository;
import org.example.Accion.UseCase.CrearAccionUseCase;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class AccionCrearUseCaseTest {
    @Mock
    ICrearAccionRepository crearAccionRepository;

    @Test
    public void crearAccion_AccionNoExiste_GuardaCorrectamente () throws AccionException, EmpresaException {
        Double precio = 300.0;
        Integer cantidad = 10;
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Accion accion = Accion.factoryAccion(1, empresa, LocalDate.now(), precio, cantidad);
        when(crearAccionRepository.guardar(accion)).thenReturn(true);
        CrearAccionUseCase crearAccionUseCase = new CrearAccionUseCase(crearAccionRepository);
        boolean resultado = crearAccionUseCase.crearAccion(accion);
        Assertions.assertTrue(resultado);
    }
}