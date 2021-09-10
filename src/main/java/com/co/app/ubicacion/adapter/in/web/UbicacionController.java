package com.co.app.ubicacion.adapter.in.web;

import com.co.app.miscellaneous.dto.GenericDto;
import com.co.app.ubicacion.application.port.out.UbicacionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController

@Api(value = "Operaciones pertenecientes a las ciudades")
@RequestMapping("/ubicacion")
public class UbicacionController {

    private final UbicacionQuery ubicacionQuery;

    @Autowired
    public UbicacionController(UbicacionQuery ubicacionQuery) {
        this.ubicacionQuery = ubicacionQuery;
    }

    @ApiOperation(value = "Listado de Ciudades", response = GenericDto.class)
    @GetMapping("/obtenerCiudades")
    public ResponseEntity<GenericDto> obtenerCiudades() {
        log.info("[{}]- consultando Ciudades, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(ubicacionQuery.obtenerCiudades()));
    }

}
