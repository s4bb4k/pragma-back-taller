package com.co.app.cliente.adapter.out.persistence;

import com.co.app.cliente.domain.ClienteDto;
import com.co.app.persistance.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ClienteRepositoryJpa extends JpaRepository<Clientes, Integer> {

    @Query(value = "SELECT nextval('seq_cliente')", nativeQuery = true)
    Integer getNextValSequence();

    @Query(nativeQuery = true)
    List<ClienteDto> obtenerCliente();

    @Query(nativeQuery = true)
    List<ClienteDto> obtenerClienteById(
            @Param("id") Integer id
    );

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Clientes (id, nombre, apellido, fecha_nacimiento, idciudad, idtipodocumento, idimagen, estado) "
            + "values (:id, :nombre, :apellido, cast(:fechanacimiento as date), :idciudad, :idtipodocumento, :idimagen, :estado) ", nativeQuery = true)
    Integer crearCliente(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("fechanacimiento") String fechanacimiento,
            @Param("idciudad") Integer idciudad,
            @Param("idtipodocumento") Integer idtipodocumento,
            @Param("idimagen") Integer idimagen,
            @Param("estado") String estado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Clientes SET "
            + "nombre = :nombre, "
            + "apellido = :apellido, "
            + "fecha_nacimiento = cast(:fechanacimiento as date), "
            + "idciudad = :idciudad, "
            + "idtipodocumento = :idtipodocumento, "
            + "idimagen = :idimagen "
            + "WHERE id = :id")
    Integer actualizarCliente(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("fechanacimiento") String fechanacimiento,
            @Param("idciudad") Integer idciudad,
            @Param("idtipodocumento") Integer idtipodocumento,
            @Param("idimagen") Integer idimagen,
            @Param("id") Integer id
    );

    @Transactional
    @Modifying
    @Query(value = "UPDATE Clientes SET "
            + "estado = :estado "
            + "WHERE id = :idCliente ")
    Integer actualizarEstadoCliente(
            @Param("estado") String estado,
            @Param("idCliente") Integer idCliente
    );

}
