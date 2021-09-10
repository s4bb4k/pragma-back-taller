package com.co.app.tipodocumento.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Dto para el manejo de los datos de la tabla tipo documento")
@Data
@AllArgsConstructor @NoArgsConstructor
public class TipoDocumentoDto {

    @ApiModelProperty(notes = "ID generado automáticamente por la BD")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty(notes = "nombre tipo documento")
    @JsonProperty("nombre")
    private String nombre;

}
