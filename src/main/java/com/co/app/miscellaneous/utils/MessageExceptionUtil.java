package com.co.app.miscellaneous.utils;

import com.co.app.miscellaneous.constant.ValidationMessageEnum;
import com.co.app.miscellaneous.dto.GenericDto;
import com.co.app.miscellaneous.dto.MessageExceptionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Log4j2
public class MessageExceptionUtil {
    @Autowired
    private ValidationMessageUtil validationMessageUtil;

    public String resolveMessage(ValidationMessageEnum messageEnum) {
        MessageExceptionDto exceptionDto = MessageExceptionDto.builder().build();
        ValidationMessage validationMessage = loadValidationMessage(messageEnum);
        exceptionDto.setValidationMessage(validationMessage);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;

        try {

            jsonStr = Obj.writeValueAsString(exceptionDto);

        } catch (IOException exception) {
            log.error("[{}] Error obteniendo JSON: dto:{}, message: {} ", Thread.currentThread().getId(), exceptionDto, exception);
        }

        return jsonStr;
    }

    public String resolveErrorMessage(ValidationMessageEnum messageEnum, int codeError) {
        MessageExceptionDto exceptionDto = MessageExceptionDto.builder().build();
        ValidationMessage validationMessage = loadValidationMessage(messageEnum);
        exceptionDto.setValidationMessage(validationMessage);

        GenericDto genericDto = new GenericDto();
        genericDto.setStatus(codeError);
        genericDto.setPayload(exceptionDto);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;

        try {

            jsonStr = Obj.writeValueAsString(genericDto);

        } catch (IOException exception) {
            log.error("[{}] Error obteniendo JSON: dto:{}, message: {} ", Thread.currentThread().getId(), exceptionDto, exception);
        }

        return jsonStr;
    }

    private ValidationMessage loadValidationMessage(ValidationMessageEnum validationMessageEnum) {
        return validationMessageUtil.loadMessage(validationMessageEnum);
    }
}
