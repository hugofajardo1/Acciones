package org.ExampleTest.CotizacionTest.UseCaseTest;

import org.example.Cotizacion.Exceptions.CotizacionException;
import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Repository.ICrearCotizacionRepository;
import org.example.Cotizacion.UseCase.CrearCotizacionUseCase;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CotizacionCrearUseCaseTest {
    @Mock
    ICrearCotizacionRepository crearCotizacionRepository;
    @Test
    public void crearCotizacion_CotizacionNoExiste_GuardaCorrectamente () throws CotizacionException, EmpresaException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Cotizacion cotizacion = Cotizacion.factoryCotizacion(1, empresa, LocalDate.now(), 290.0);
        when(crearCotizacionRepository.guardar(cotizacion)).thenReturn(true);
        CrearCotizacionUseCase crearCotizacionUseCase = new CrearCotizacionUseCase(crearCotizacionRepository);
        boolean resultado = crearCotizacionUseCase.crearCotizacion(cotizacion);
        Assertions.assertTrue(resultado);
    }

}
