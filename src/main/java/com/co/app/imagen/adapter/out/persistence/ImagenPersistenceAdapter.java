package com.co.app.imagen.adapter.out.persistence;

import com.co.app.imagen.application.port.out.ImagenQuery;
import com.co.app.imagen.domain.ImagenDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class ImagenPersistenceAdapter implements ImagenQuery {

    private final ImagenRepositoryJpa imagenRepositoryJpa;

    public ImagenPersistenceAdapter(ImagenRepositoryJpa imagenRepositoryJpa) {
        this.imagenRepositoryJpa = imagenRepositoryJpa;
    }

    @Override
    public ImagenDto obtenerImagen(Integer idImagen) {
        return imagenRepositoryJpa.obtenerImagen(idImagen);
    }

    @Transactional
    @Override
    public ImagenDto crearImagen(ImagenDto imagenDto) {
        Integer id = imagenRepositoryJpa.getNextValSequence();
        imagenDto.setId(id);

        imagenRepositoryJpa.crearImagen(
                imagenDto.getId(),
                imagenDto.getUrl(),
                imagenDto.getPeso(),
                imagenDto.getNombre(),
                imagenDto.getExt()
        );
        return imagenDto;
    }

    @Transactional
    @Override
    public ImagenDto actualizarImagen(ImagenDto imagenDto) {

        imagenRepositoryJpa.actualizarImagen(
                imagenDto.getUrl(),
                imagenDto.getPeso(),
                imagenDto.getNombre(),
                imagenDto.getExt(),
                imagenDto.getId()
        );
        return imagenDto;
    }

}
