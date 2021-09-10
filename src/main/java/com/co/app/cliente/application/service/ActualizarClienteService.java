package com.co.app.cliente.application.service;

import com.co.app.cliente.application.port.in.ActualizarClienteUseCase;
import com.co.app.cliente.application.port.out.ClienteQuery;
import com.co.app.cliente.domain.ClienteDto;
import com.co.app.imagen.application.port.out.ImagenQuery;
import com.co.app.imagen.domain.ImagenDto;
import com.co.app.miscellaneous.utils.Sistema;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ActualizarClienteService implements ActualizarClienteUseCase {

    private final ClienteQuery clienteQuery;
    private final ImagenQuery imagenQuery;

    public ActualizarClienteService(ClienteQuery clienteQuery, ImagenQuery imagenQuery) {
        this.clienteQuery = clienteQuery;
        this.imagenQuery = imagenQuery;
    }

    @Override
    public ClienteDto actualizarCliente(ClienteDto clienteDto) {

        if (clienteDto.getImageData() != null) {
            if (clienteDto.getIdimagen() != null) {
                ImagenDto resultImagenDto = imagenQuery.obtenerImagen(clienteDto.getIdimagen());
                Sistema.deleteImage(resultImagenDto.getUrl());
                ImagenDto imagenDto = Sistema.uploadImage(clienteDto.getExt(), clienteDto.getImageData(), clienteDto.getPeso());
                imagenDto.setId(resultImagenDto.getId());
                imagenQuery.actualizarImagen(imagenDto);
            }
        }

        // Actualizar Producto General
        clienteQuery.actualizarCliente(clienteDto);

        return null;
    }
}
