package org.example.Cotizacion.Repository;

import org.example.Cotizacion.Model.Cotizacion;
import org.example.Empresa.Model.Empresa;

import java.util.List;

public interface ICotizacionObtenerRepository {
    List<Cotizacion> obtenerCotizaciones(Empresa empresa);
}
