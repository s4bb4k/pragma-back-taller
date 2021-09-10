package com.co.app.ubicacion.adapter.out.persistence;

import com.co.app.ubicacion.application.port.out.UbicacionQuery;
import com.co.app.ubicacion.domain.CiudadDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UbicacionPersistenceAdapter implements UbicacionQuery {

    private final CiudadRepositoryJpa ciudadRepositoryJpa;

    public UbicacionPersistenceAdapter(CiudadRepositoryJpa ciudadRepositoryJpa) {
        this.ciudadRepositoryJpa = ciudadRepositoryJpa;
    }

    @Override
    public List<CiudadDto> obtenerCiudades() {
        log.info("[{}]- consultando Ciudades, message{}..", Thread.currentThread().getId());
        return ciudadRepositoryJpa.obtenerCiudades();
    }

}
