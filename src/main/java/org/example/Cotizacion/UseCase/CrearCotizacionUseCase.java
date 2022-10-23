package org.example.Cotizacion.UseCase;


import org.example.Cotizacion.Input.ICrearCotizacionInput;
import org.example.Cotizacion.Model.Cotizacion;
import org.example.Cotizacion.Repository.ICrearCotizacionRepository;

public class CrearCotizacionUseCase implements ICrearCotizacionInput {

    ICrearCotizacionRepository crearCotizacionRepository;
    public CrearCotizacionUseCase(ICrearCotizacionRepository crearCotizacionRepository){ this.crearCotizacionRepository = crearCotizacionRepository; }
    @Override
    public boolean crearCotizacion(Cotizacion cotizacion) {
        return crearCotizacionRepository.guardar(cotizacion);
    }
}
