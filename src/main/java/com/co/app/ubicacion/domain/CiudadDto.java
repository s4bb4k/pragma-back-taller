package com.co.app.ubicacion.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Dto para el manejo de los datos de la tabla ciudades")
@Data @AllArgsConstructor @NoArgsConstructor
public class CiudadDto {

    @ApiModelProperty(notes = "ID generado automáticamente por la BD")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty(notes = "nombre de la ciudad")
    @JsonProperty("nombre")
    private String nombre;

}
