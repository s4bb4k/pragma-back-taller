package com.co.app.tipodocumento.adapter.out.persistence;

import com.co.app.persistance.model.TipoDocumento;
import com.co.app.tipodocumento.domain.TipoDocumentoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDocuRepositoryJpa extends JpaRepository<TipoDocumento, Integer> {

    @Query(value = "SELECT nextval('seq_tipodocumento')", nativeQuery = true)
    Integer getNextValSequence();

    @Query(value = "SELECT new com.co.app.tipodocumento.domain.TipoDocumentoDto( "
            + "td.id, "
            + "td.nombre) "
            + "FROM TipoDocumento td")
    List<TipoDocumentoDto> obtenerTipoDocumento();

}
