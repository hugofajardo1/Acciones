package org.ExampleTest.Agente.UseCaseTest;

import org.example.Agente.Exceptions.AgenteException;
import org.example.Agente.Model.Agente;
import org.example.Agente.Repository.IObtenerAgenteRepository;
import org.example.Agente.UseCase.AgenteEvaluaEstrategiasUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(mockito.MockitoExtension.class)
public class AgenteEvaluarEstrategiasUseCase {
    @Mock
    IObtenerAgenteRepository obtenerAgenteRepository;
    @Test
    public void EvaluarEstrategias() throws AgenteException {
        Agente agente = Agente.factoryAgente(1, "Hugo Fajardo", 1000000.0);
        when(obtenerAgenteRepository.obtenerAgente(1)).thenReturn(agente);
        AgenteEvaluaEstrategiasUseCase evaluaEstrategiasUseCase = new AgenteEvaluaEstrategiasUseCase(obtenerAgenteRepository);
        evaluaEstrategiasUseCase.evaluaEstrategia(1);

    }
}
