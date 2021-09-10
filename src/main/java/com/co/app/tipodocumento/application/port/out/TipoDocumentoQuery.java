package com.co.app.tipodocumento.application.port.out;

import com.co.app.tipodocumento.domain.TipoDocumentoDto;

import java.util.List;

public interface TipoDocumentoQuery {

    public List<TipoDocumentoDto> obtenerTipoDocumento();

}
