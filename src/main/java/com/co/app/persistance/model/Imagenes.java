/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.app.persistance.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Christian.Morales
 */
@Entity
@Table(name = "imagenes")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i"),
        @NamedQuery(name = "Imagenes.findById", query = "SELECT i FROM Imagenes i WHERE i.id = :id"),
        @NamedQuery(name = "Imagenes.findByUrl", query = "SELECT i FROM Imagenes i WHERE i.url = :url"),
        @NamedQuery(name = "Imagenes.findByPeso", query = "SELECT i FROM Imagenes i WHERE i.peso = :peso"),
        @NamedQuery(name = "Imagenes.findByExt", query = "SELECT i FROM Imagenes i WHERE i.ext = :ext"),
        @NamedQuery(name = "Imagenes.findByDefecto", query = "SELECT i FROM Imagenes i WHERE i.defecto = :defecto"),
        @NamedQuery(name = "Imagenes.findByNombre", query = "SELECT i FROM Imagenes i WHERE i.nombre = :nombre")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "url")
    private String url;
    @Column(name = "peso")
    private String peso;
    @Column(name = "ext")
    private String ext;
    @Column(name = "defecto")
    private Boolean defecto;
    @Lob
    @Column(name = "base64")
    private byte[] base64;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idimagen")
    private List<Clientes> clientesList;

    public Imagenes() {
    }

    public Imagenes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }

    public byte[] getBase64() {
        return base64;
    }

    public void setBase64(byte[] base64) {
        this.base64 = base64;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
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
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagenes[ id=" + id + " ]";
    }

}
