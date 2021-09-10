package com.co.app.ubicacion.application.port.out;

import com.co.app.ubicacion.domain.CiudadDto;

import java.util.List;

public interface UbicacionQuery {

    public List<CiudadDto> obtenerCiudades();

}
