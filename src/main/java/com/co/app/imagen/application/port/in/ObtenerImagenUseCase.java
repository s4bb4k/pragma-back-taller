package com.co.app.imagen.application.port.in;

import com.co.app.imagen.domain.ImagenDto;

public interface ObtenerImagenUseCase {

    public ImagenDto obtenerImagen(Integer idImagen);

}
