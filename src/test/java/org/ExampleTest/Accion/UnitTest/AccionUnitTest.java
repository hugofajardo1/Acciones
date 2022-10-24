package org.ExampleTest.Accion.UnitTest;

import org.example.Accion.Exceptions.AccionException;
import org.example.Accion.Model.Accion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccionUnitTest {
    @Test
    void instanciarAccion_AccionCompleta_InstanciaCorrecta() throws AccionException {
        Double precio = 300.0;
        Integer cantidad = 10;
        Accion accion = Accion.factoryAccion(1, LocalDate.now(), precio, cantidad);
        assertNotNull(accion);
    }
    @Test
    void instanciarAccion_AccionIncompleta_InstanciaNoCorrecta() {
        Double precio = 300.0;
        Integer cantidad = 0;
        Assertions.assertThrows(AccionException.class,()-> Accion.factoryAccion(1, LocalDate.now(), precio, cantidad));
    }
}