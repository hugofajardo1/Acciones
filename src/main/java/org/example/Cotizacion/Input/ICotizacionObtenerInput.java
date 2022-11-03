package org.example.Cotizacion.Input;

import org.example.Cotizacion.Model.Cotizacion;
import org.example.Empresa.Model.Empresa;

import java.util.List;

public interface ICotizacionObtenerInput {
    List<Cotizacion> obtenerCotizaciones(Empresa empresa);
}
