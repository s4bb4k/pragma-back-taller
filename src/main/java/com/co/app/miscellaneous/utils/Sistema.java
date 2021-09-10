package com.co.app.miscellaneous.utils;

import com.co.app.imagen.domain.ImagenDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema {

    public static Date getFechaActual() {

        Date dtFechaActual;

        Calendar objCalendario = Calendar.getInstance();
        objCalendario.set(Calendar.HOUR_OF_DAY, 0);
        objCalendario.set(Calendar.MINUTE, 0);
        objCalendario.set(Calendar.SECOND, 0);
        objCalendario.set(Calendar.MILLISECOND, 0);
        dtFechaActual = new Date(objCalendario.getTime().getTime());

        return dtFechaActual;

    }

    public static ImagenDto uploadImage(String ext, String ImagenData, String peso) {

        ImagenDto imagenDto = new ImagenDto();

        // Obtenemos el path donde se guardara la imagen
        StringBuilder sbPath = new StringBuilder();
        sbPath.append("C:\\Users\\Cristian.Morales\\Documents\\workspace-cursos\\cliente-service\\src\\main\\images");

        String part1 = "";
        String part2 = "";

        // Obtenemos la extension
        if (ext.contains("/")) {
            String[] parts = ext.split("/");
            part1 = parts[0];
            part2 = parts[1];
        } else {
            part2 = ext;
        }
        String extension = "." + part2;

        // Definimos el nombre del archivo
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());

        int anio = (cal.get(Calendar.YEAR));
        int mes = (cal.get(Calendar.MONTH) + 1);
        int dia = (cal.get(Calendar.DATE));
        int hora = (cal.get(Calendar.HOUR));
        int min = (cal.get(Calendar.MINUTE));
        int sec = (cal.get(Calendar.SECOND));
        int mili = (cal.get(Calendar.MILLISECOND));

        // Asignamos el nombre de la imagen
        String nombreImagenConExt = anio + "" + mes + "" + dia + "" + hora + "" + min + "" + sec + "" + mili + extension;
        String nombreImagen = anio + "" + mes + "" + dia + "" + hora + "" + min + "" + sec + "" + mili;
        sbPath.append(nombreImagenConExt);

        // Creamos el archivo
        ArchivoUtils.createFile(sbPath.toString(), ImagenData.split(",")[1]);

        // Asignamos las propiedades al Dto que vamos a devolver
        imagenDto.setNombre(nombreImagen);
        imagenDto.setExt(part2);
        imagenDto.setUrl(sbPath.toString());
        imagenDto.setPeso(peso);

        return imagenDto;
    }

    public static ImagenDto deleteImage(String url) {
        ImagenDto imagenDto = new ImagenDto();

        // Eliminamos el path de la imagen que se va actualizar
        try {
            Path path = Paths.get(url);
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            System.out.println("Error al eliminar la imagen");
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imagenDto;
    }

}
