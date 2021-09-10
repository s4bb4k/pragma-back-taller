package com.co.app.imagen.adapter.in.web;

import com.co.app.imagen.application.port.in.ObtenerImagenUseCase;
import com.co.app.imagen.application.port.out.ImagenQuery;
import com.co.app.miscellaneous.dto.GenericDto;
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
@RequestMapping("/imagen")
public class ImagenController {

    private final ImagenQuery imagenQuery;
    private final ObtenerImagenUseCase obtenerImagenUseCase;

    public ImagenController(ImagenQuery imagenQuery, ObtenerImagenUseCase obtenerImagenUseCase) {
        this.imagenQuery = imagenQuery;
        this.obtenerImagenUseCase = obtenerImagenUseCase;
    }

    @ApiOperation(value = "obtener imagen filtrada por id", response = GenericDto.class)
    @GetMapping("/obtenerImagen/{idImagen}")
    public ResponseEntity<GenericDto> obtenerImagen(@PathVariable("idImagen") Integer idImagen) {
        log.info("[{}]- consultando Imagen filtrada por id, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(obtenerImagenUseCase.obtenerImagen(idImagen)));
    }

}
