package org.example.Agente.UseCase;

import org.example.Agente.Input.IAgenteEvaluaEstrategia;
import org.example.Agente.Model.Agente;
import org.example.Agente.Repository.IObtenerAgenteRepository;

public class AgenteEvaluaEstrategiasUseCase implements IAgenteEvaluaEstrategia {
    IObtenerAgenteRepository obtenerAgenteRepository;

    public AgenteEvaluaEstrategiasUseCase(IObtenerAgenteRepository obtenerAgenteRepository) {
        this.obtenerAgenteRepository = obtenerAgenteRepository;
    }

    @Override
    public void evaluaEstrategia(int id) {
        Agente agente = obtenerAgenteRepository.obtenerAgente(id);
        if(agente!=null)
            agente.EvaluarEstrategias();
    }
}
