package com.co.app.miscellaneous.dto;

import com.co.app.miscellaneous.utils.ValidationMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Map;

@Data
@Builder
@Log4j2
public class MessageExceptionDto {

    @Builder.Default
    private String code = "A00";
    private String message;
    @Builder.Default
    private String recomen = "Comuniquese con el administrador";

    public void setValidationMessage(ValidationMessage validationMessage) {
        this.code = validationMessage.getCode();
        this.message = validationMessage.getMessage();
        this.recomen = validationMessage.getRecomen();
    }

    public void setData(String dataJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(dataJson, Map.class);

            this.code = map.get("code");
            this.message = map.get("messages");
            this.recomen = map.get("recomen");

        } catch (IOException e) {
            log.error("[{}] Error generando mapa a partir de json para String: {}, message:{}",
                    Thread.currentThread().getId(), dataJson, e.getMessage());
        }
    }

}
