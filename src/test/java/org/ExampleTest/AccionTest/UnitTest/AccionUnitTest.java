package org.ExampleTest.AccionTest.UnitTest;

import org.example.Accion.Exceptions.AccionException;
import org.example.Accion.Model.Accion;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccionUnitTest {
    @Test
    void instanciarAccion_AccionCompleta_InstanciaCorrecta() throws AccionException, EmpresaException {
        Double precio = 300.0;
        Integer cantidad = 10;
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Accion accion = Accion.factoryAccion(1, empresa, LocalDate.now(), precio, cantidad);
        assertNotNull(accion);
    }
    @Test
    void instanciarAccion_AccionIncompleta_InstanciaNoCorrecta() throws EmpresaException {
        Double precio = 300.0;
        Integer cantidad = 0;
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        Assertions.assertThrows(AccionException.class,()-> Accion.factoryAccion(1, empresa, LocalDate.now(), precio, cantidad));
    }
}