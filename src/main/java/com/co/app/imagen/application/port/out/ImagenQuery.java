package com.co.app.imagen.application.port.out;

import com.co.app.imagen.domain.ImagenDto;

public interface ImagenQuery {

    public ImagenDto crearImagen(ImagenDto imagenDto);

    public ImagenDto actualizarImagen(ImagenDto imagenDto);

    public ImagenDto obtenerImagen(Integer idImagen);

}
