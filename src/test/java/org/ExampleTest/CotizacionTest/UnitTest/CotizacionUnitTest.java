package org.ExampleTest.CotizacionTest.UnitTest;

import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Exceptions.CotizacionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CotizacionUnitTest {
    @Test
    void instanciarCotizacion_CotizacionCompleta_InstanciaCorrecta() throws CotizacionException {
        Cotizacion cotizacion = Cotizacion.factoryCotizacion(1, "L-Fancy", 12345678);
        assertNotNull(cotizacion);

        assertEquals(12345678, cotizacion.getLegajo());
    }

}
