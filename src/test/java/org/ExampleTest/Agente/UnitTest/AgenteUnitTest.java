package org.ExampleTest.Agente.UnitTest;

import org.example.Agente.Exceptions.AgenteException;
import org.example.Agente.Model.Agente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AgenteUnitTest {
    @Test
    void instanciarAgente_AgenteCompleta_InstanciaCorrecta() throws AgenteException {
        Agente empresa = Agente.factoryAgente(1, "YPF");
        assertNotNull(empresa);
    }
    @Test
    void instanciarAgente_AgenteIncompleta_InstanciaNoCorrecta() {
        Assertions.assertThrows(AgenteException.class,()-> Agente.factoryAgente(1, ""));
    }
}