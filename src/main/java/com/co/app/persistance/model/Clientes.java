/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.app.persistance.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.co.app.cliente.domain.ClienteDto;

/**
 *
 * @author Christian.Morales
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
        @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id"),
        @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
        @NamedQuery(name = "Clientes.findByApellido", query = "SELECT c FROM Clientes c WHERE c.apellido = :apellido"),
        @NamedQuery(name = "Clientes.findByFechaNacimiento", query = "SELECT c FROM Clientes c WHERE c.fechaNacimiento = :fechaNacimiento"),
        @NamedQuery(name = "Clientes.findByEstado", query = "SELECT c FROM Clientes c WHERE c.estado = :estado")})

@SqlResultSetMapping(name = "ClienteMapping",
classes = {
    @ConstructorResult(
            targetClass = ClienteDto.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "nombre", type = String.class),
                @ColumnResult(name = "apellido", type = String.class),
                @ColumnResult(name = "fecha_nacimiento", type = String.class),
                @ColumnResult(name = "ciudad", type = String.class),
                @ColumnResult(name = "tipodocumento", type = String.class),
                @ColumnResult(name = "url", type = String.class)
            }
    )
})

@NamedNativeQueries({
	@NamedNativeQuery(name = "Clientes.obtenerCliente",
            query = "SELECT "
            + "c.id, "
            + "c.nombre, "
            + "c.apellido, "
            + "c.fecha_nacimiento, "
            + "ci.nombre, "
            + "td.nombre, "
            + "img.url "
            + "FROM clientes c "
            + "INNER JOIN ciudades ci ON c.idciudad = ci.id "
            + "INNER JOIN tipo_documento td ON c.idtipodocumento = td.id "
            + "INNER JOIN imagenes img ON c.idimagen = img.id "
            + "ORDER BY c.id DESC ",
            resultSetMapping = "ClienteMapping"),
    @NamedNativeQuery(name = "Clientes.obtenerClienteById",
            query = "SELECT "
                    + "c.id, "
                    + "c.nombre, "
                    + "c.apellido, "
                    + "c.fecha_nacimiento, "
                    + "ci.nombre, "
                    + "td.nombre, "
                    + "img.url "
                    + "FROM clientes c "
                    + "INNER JOIN ciudades ci ON c.idciudad = ci.id "
                    + "INNER JOIN tipo_documento td ON c.idtipodocumento = td.id "
                    + "INNER JOIN imagenes img ON c.idimagen = img.id "
                    + "WHERE c.id = :id "
                    + "ORDER BY c.id DESC ",
            resultSetMapping = "ClienteMapping"),
})


public class Clientes implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "apellido")
        private String apellido;
        @Column(name = "fecha_nacimiento")
        private String fechaNacimiento;
        @Column(name = "estado")
        private String estado;
        @JoinColumn(name = "idciudad", referencedColumnName = "id")
        @ManyToOne
        private Ciudades idciudad;
        @JoinColumn(name = "idimagen", referencedColumnName = "id")
        @ManyToOne
        private Imagenes idimagen;
        @JoinColumn(name = "idtipodocumento", referencedColumnName = "id")
        @ManyToOne
        private TipoDocumento idtipodocumento;

        public Clientes() {
        }

        public Clientes(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Ciudades getIdciudad() {
            return idciudad;
        }

        public void setIdciudad(Ciudades idciudad) {
            this.idciudad = idciudad;
        }

        public Imagenes getIdimagen() {
            return idimagen;
        }

        public void setIdimagen(Imagenes idimagen) {
            this.idimagen = idimagen;
        }

        public TipoDocumento getIdtipodocumento() {
            return idtipodocumento;
        }

        public void setIdtipodocumento(TipoDocumento idtipodocumento) {
            this.idtipodocumento = idtipodocumento;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (id != null ? id.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Clientes)) {
                return false;
            }
            Clientes other = (Clientes) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Clientes[ id=" + id + " ]";
        }
}
