package com.co.app.imagen.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Dto para el manejo de los datos de la tabla imagenes")
@Data
public class ImagenDto {

    @ApiModelProperty(notes = "ID generado automáticamente por la BD")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty(notes = "Url imagen")
    @JsonProperty("url")
    private String url;

    @ApiModelProperty(notes = "Nombre imagen")
    @JsonProperty("image_name")
    private String nombre;

    @ApiModelProperty(notes = "tipo imagen")
    @JsonProperty("image_type")
    private String ext;

    @ApiModelProperty(notes = "Tamaño de la imagen")
    @JsonProperty("image_size")
    private String peso;

    @ApiModelProperty(notes = "Base64 de la imagen")
    @JsonProperty("image_data")
    private String base64;

    @ApiModelProperty(notes = "Define si la imagen es propia del sistema")
    @JsonProperty("defecto")
    private Boolean defecto;

    public ImagenDto() {
    }

    //Constructor Create
    public ImagenDto(Integer id, String url, String peso, String nombre, String ext) {
        this.id = id;
        this.url = url;
        this.peso = peso;
        this.nombre = nombre;
        this.ext = ext;
    }

    //Constructor Update
    public ImagenDto(String url, String peso, String nombre, String ext, Integer id) {
        this.url = url;
        this.peso = peso;
        this.nombre = nombre;
        this.ext = ext;
        this.id = id;
    }

    // Constructor Get
    public ImagenDto(Integer id, String url, String nombre, String ext, String peso, String base64, Boolean defecto) {
        this.id = id;
        this.url = url;
        this.nombre = nombre;
        this.ext = ext;
        this.peso = peso;
        this.base64 = base64;
        this.defecto = defecto;
    }

}
