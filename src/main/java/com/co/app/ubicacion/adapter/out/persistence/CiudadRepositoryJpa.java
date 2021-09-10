package com.co.app.ubicacion.adapter.out.persistence;

import com.co.app.persistance.model.Ciudades;
import com.co.app.ubicacion.domain.CiudadDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CiudadRepositoryJpa extends JpaRepository<Ciudades, Integer> {

    @Query( value = "SELECT new com.co.app.ubicacion.domain.CiudadDto("
            + "c.id,"
            + "c.nombre) "
            + "FROM Ciudades AS c "
            + "ORDER BY c.nombre ASC")
    List<CiudadDto> obtenerCiudades();

}
