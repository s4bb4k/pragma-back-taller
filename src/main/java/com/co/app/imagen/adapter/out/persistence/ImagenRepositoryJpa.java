package com.co.app.imagen.adapter.out.persistence;

import com.co.app.imagen.domain.ImagenDto;
import com.co.app.persistance.model.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImagenRepositoryJpa extends JpaRepository<Imagenes, Integer> {

    @Query(value = "SELECT nextval('seq_imagen')", nativeQuery = true)
    Integer getNextValSequence();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Imagenes ( id, url, peso, nombre, ext) "
            + "VALUES ( :id, :url, :peso, :nombre, :ext)", nativeQuery = true)
    Integer crearImagen(
            @Param("id") Integer id,
            @Param("url") String url,
            @Param("peso") String peso,
            @Param("nombre") String nombre,
            @Param("ext") String ext
    );

    @Transactional
    @Modifying
    @Query(value = "UPDATE Imagenes SET "
            + "url =:url, "
            + "peso =:peso, "
            + "nombre =:nombre, "
            + "ext =:ext "
            + "WHERE id =:id", nativeQuery = true)
    Integer actualizarImagen(
            @Param("url") String url,
            @Param("peso") String peso,
            @Param("nombre") String nombre,
            @Param("ext") String ext,
            @Param("id") Integer id
    );

    @Query(value = "SELECT new com.co.app.imagen.domain.ImagenDto("
            + "i.id, "
            + "i.url, "
            + "i.peso, "
            + "i.nombre, "
            + "i.ext) "
            + "FROM Imagenes AS i "
            + "WHERE i.id =:id")
    ImagenDto obtenerImagen(
            @Param("id") Integer id
    );

}
