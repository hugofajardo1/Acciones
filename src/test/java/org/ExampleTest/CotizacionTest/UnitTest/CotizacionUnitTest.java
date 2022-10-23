package org.ExampleTest.CotizacionTest.UnitTest;

import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Exceptions.CotizacionException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CotizacionUnitTest {
    @Test
    void instanciarCotizacion_CotizacionCompleta_InstanciaCorrecta() throws CotizacionException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Cotizacion cotizacion = Cotizacion.factoryCotizacion(1, empresa, LocalDate.now());
        assertNotNull(cotizacion);
    }

}
