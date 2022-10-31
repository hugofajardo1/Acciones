package org.ExampleTest.CotizacionTest.UnitTest;

import org.example.Cotizacion.Exceptions.CotizacionAtributoNuloException;
import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Exceptions.CotizacionException;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CotizacionUnitTest {
    @Test
    void instanciarCotizacion_CotizacionCompleta_InstanciaCorrecta() throws CotizacionException, EmpresaException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Cotizacion cotizacion = Cotizacion.factoryCotizacion(1, empresa, LocalDate.now(), 290.0);
        assertNotNull(cotizacion);
    }
    @Test
    void instanciarCotizacion_CotizacionIncompleta_InstanciaNoCorrecta() {
        Assertions.assertThrows(CotizacionAtributoNuloException.class,()-> Cotizacion.factoryCotizacion(1, null, LocalDate.now(), 290.0));
    }
}
