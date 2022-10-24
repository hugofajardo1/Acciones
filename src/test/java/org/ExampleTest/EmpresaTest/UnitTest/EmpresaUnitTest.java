package org.ExampleTest.EmpresaTest.UnitTest;

import org.example.Empresa.Exceptions.EmpresaAtributoNuloException;
import org.example.Empresa.Exceptions.EmpresaException;
import org.example.Empresa.Model.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmpresaUnitTest {
    @Test
    void instanciarEmpresa_EmpresaCompleta_InstanciaCorrecta() throws EmpresaException {
        Empresa empresa = Empresa.factoryEmpresa(1, "YPF");
        assertNotNull(empresa);
    }
    @Test
    void instanciarEmpresa_EmpresaIncompleta_InstanciaNoCorrecta() {
        Assertions.assertThrows(EmpresaException.class,()-> Empresa.factoryEmpresa(1, ""));
    }
}
