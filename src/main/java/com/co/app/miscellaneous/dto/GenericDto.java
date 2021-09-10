package com.co.app.miscellaneous.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

@ApiModel(description = "Atributos genericos de respuesta de los servicios")
@Data
public class GenericDto {

    @ApiModelProperty(notes = "estado de la petición")
    private Integer status;
    @ApiModelProperty(notes = "carga util, datos de repuesta")
    private Object payload;

    public static GenericDto sucess(Object data) {

        GenericDto genericDto = new GenericDto();
        //genericDto.setStatus(HttpStatus.OK.toString());
        genericDto.setStatus(HttpStatus.OK.value());
        genericDto.setPayload(data);

        return genericDto;
    }

    public static GenericDto failed(Object data) {
        GenericDto genericDto = new GenericDto();
        genericDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        genericDto.setPayload(data);

        return genericDto;
    }

}
