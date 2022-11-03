package org.example.Cotizacion.UseCase;

import org.example.Cotizacion.Input.ICotizacionObtenerInput;
import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Repository.ICotizacionObtenerRepository;
import org.example.Empresa.Model.Empresa;

import java.util.List;

public class CotizacionObtenerUseCase implements ICotizacionObtenerInput {

    ICotizacionObtenerRepository cotizacionObtenerRepository;

    public CotizacionObtenerUseCase(ICotizacionObtenerRepository cotizacionObtenerRepository) {
        this.cotizacionObtenerRepository = cotizacionObtenerRepository;
    }

    @Override
    public List<Cotizacion> obtenerCotizaciones(Empresa empresa) {
        return cotizacionObtenerRepository.obtenerCotizaciones(empresa);
    }
}
