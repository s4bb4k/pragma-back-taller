package com.co.app.imagen.application.service;

import com.co.app.imagen.application.port.in.ObtenerImagenUseCase;
import com.co.app.imagen.application.port.out.ImagenQuery;
import com.co.app.imagen.domain.ImagenDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
@Service
public class ObtenerImagenService implements ObtenerImagenUseCase {

    private final ImagenQuery imagenQuery;

    public ObtenerImagenService(ImagenQuery imagenQuery) {
        this.imagenQuery = imagenQuery;
    }

    @Override
    public ImagenDto obtenerImagen(Integer idImagen) {

        ImagenDto imagenDto = imagenQuery.obtenerImagen(idImagen);

        BufferedImage imagen = null;

        try {
            //Obtenemos la imagen
            File fileImage = new File(imagenDto.getUrl());
            imagen = ImageIO.read(fileImage);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(imagen, imagenDto.getExt(), bos);

            byte[] data = bos.toByteArray();
            String imgB64 = Base64.getEncoder().encodeToString(data);
            String imgFormatB64 = "data:image/"+ imagenDto.getExt() +";base64," + imgB64;
            imagenDto.setBase64(imgFormatB64);

        } catch (IOException ex) {
            Logger.getLogger(ObtenerImagenService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagenDto;
    }

}
