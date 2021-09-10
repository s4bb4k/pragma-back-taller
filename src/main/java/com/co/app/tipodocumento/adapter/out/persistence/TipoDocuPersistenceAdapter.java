package com.co.app.tipodocumento.adapter.out.persistence;

import com.co.app.tipodocumento.application.port.out.TipoDocumentoQuery;
import com.co.app.tipodocumento.domain.TipoDocumentoDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TipoDocuPersistenceAdapter implements TipoDocumentoQuery {

    private final TipoDocuRepositoryJpa tipoDocuRepositoryJpa;

    public TipoDocuPersistenceAdapter(TipoDocuRepositoryJpa tipoDocuRepositoryJpa) {
        this.tipoDocuRepositoryJpa = tipoDocuRepositoryJpa;
    }

    @Override
    public List<TipoDocumentoDto> obtenerTipoDocumento() {
        return tipoDocuRepositoryJpa.obtenerTipoDocumento();
    }

}
