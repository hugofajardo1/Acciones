package org.ExampleTest.Agente.UseCaseTest;

import org.example.Agente.Exceptions.AgenteException;
import org.example.Agente.Model.Agente;
import org.example.Agente.Repository.ICrearAgenteRepository;
import org.example.Agente.Repository.IVerificarAgenteRepository;
import org.example.Agente.UseCase.CrearAgenteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class AgenteCrearUseCaseTest {
    @Mock
    ICrearAgenteRepository crearAgenteRepository;

    @Mock
    IVerificarAgenteRepository verificarAgenteRepository;

    @Test
    public void crearAgente_AgenteNoExiste_GuardaCorrectamente () throws AgenteException {
        Agente agente = Agente.factoryAgente(1, "Hugo Fajardo", 0.0);
        when(crearAgenteRepository.guardar(agente)).thenReturn(true);
        CrearAgenteUseCase crearAgenteUseCase = new CrearAgenteUseCase(crearAgenteRepository, verificarAgenteRepository);
        boolean resultado = crearAgenteUseCase.crearAgente(agente);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearAgente_AgenteExiste_NoGuarda () throws AgenteException {
        Agente empresa = Agente.factoryAgente(1, "Hugo Fajardo", 0.0);
        when(verificarAgenteRepository.existeAgente(empresa.getNombre())).thenReturn(true);
        when(crearAgenteRepository.guardar(empresa)).thenReturn(true);
        CrearAgenteUseCase crearAgenteUseCase = new CrearAgenteUseCase(crearAgenteRepository, verificarAgenteRepository);
        boolean resultado = crearAgenteUseCase.crearAgente(empresa);
        Assertions.assertFalse(resultado);
    }
}
