package org.ExampleTest.CotizacionTest.UseCaseTest;

import org.example.Cotizacion.Exceptions.CotizacionAtributoNuloException;
import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Repository.ICotizacionObtenerRepository;
import org.example.Cotizacion.UseCase.CotizacionObtenerUseCase;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class CotizacionObtenerUseCaseTest {
    @Mock
    ICotizacionObtenerRepository cotizacionObtenerRepository;

    @Test
    public void obtenerCotizaciones_DevuelveLista() throws EmpresaException, CotizacionAtributoNuloException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        List<Cotizacion> cotizaciones = new ArrayList<>();
        Cotizacion cot1 = Cotizacion.factoryCotizacion(1, empresa, LocalDate.now(), 300.0);
        Cotizacion cot2 = Cotizacion.factoryCotizacion(1, empresa, LocalDate.now().minusDays(1), 290.0);
        cotizaciones.add(cot1);
        cotizaciones.add(cot2);

        when(cotizacionObtenerRepository.obtenerCotizaciones(empresa)).thenReturn(cotizaciones);
        CotizacionObtenerUseCase cotizacionObtenerUseCase = new CotizacionObtenerUseCase(cotizacionObtenerRepository);
        List<Cotizacion> resultado = cotizacionObtenerUseCase.obtenerCotizaciones(empresa);
        Assertions.assertEquals(2, resultado.size());
    }
}
