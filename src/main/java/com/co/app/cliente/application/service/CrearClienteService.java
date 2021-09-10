package com.co.app.cliente.application.service;

import com.co.app.cliente.application.port.in.CrearClienteUseCase;
import com.co.app.cliente.application.port.out.ClienteQuery;
import com.co.app.cliente.domain.ClienteDto;
import com.co.app.imagen.application.port.out.ImagenQuery;
import com.co.app.imagen.domain.ImagenDto;
import com.co.app.miscellaneous.utils.Constante;
import com.co.app.miscellaneous.utils.Sistema;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CrearClienteService implements CrearClienteUseCase {

    private final ClienteQuery clienteQuery;
    private final ImagenQuery imagenQuery;

    @Autowired
    public CrearClienteService(ClienteQuery clienteQuery, ImagenQuery imagenQuery) {
        this.clienteQuery = clienteQuery;
        this.imagenQuery = imagenQuery;
    }

    @Override
    public ClienteDto crearCliente(ClienteDto clienteDto) {



        if (clienteDto.getUrl() == null) {

            clienteDto.setExt(Constante.EXTENSION_CLIENTE_POR_DEFECTO);
            clienteDto.setImageData(Constante.IMAGEN_CLIENTE_POR_DEFECTO);
            clienteDto.setPeso(Constante.PESO_CLIENTE_POR_DEFECTO);
        }

        ImagenDto imagenDto = Sistema.uploadImage(clienteDto.getExt(), clienteDto.getImageData(), clienteDto.getPeso());
        ImagenDto resultImage = imagenQuery.crearImagen(imagenDto);


        clienteDto.setIdimagen(resultImage.getId());

        clienteQuery.crearCliente(clienteDto);

        return clienteDto;
    }
}
