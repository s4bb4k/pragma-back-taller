package com.co.app.tipodocumento.adapter.in.web;

import com.co.app.miscellaneous.dto.GenericDto;
import com.co.app.tipodocumento.application.port.out.TipoDocumentoQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@Api(value = "Operaciones pertenecientes a las imagenes")
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

    private final TipoDocumentoQuery tipoDocumentoQuery;

    public TipoDocumentoController(TipoDocumentoQuery tipoDocumentoQuery) {
        this.tipoDocumentoQuery = tipoDocumentoQuery;
    }

    @ApiOperation(value = "Listado de Tipo documento", response = GenericDto.class)
    @GetMapping("/obtenerTipoDocumento")
    public ResponseEntity<GenericDto> obtenerImagen() {
        log.info("[{}]- consultando Tipo documento, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(tipoDocumentoQuery.obtenerTipoDocumento()));
    }

}
