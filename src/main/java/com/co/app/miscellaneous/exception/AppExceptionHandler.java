package com.co.app.miscellaneous.exception;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.co.app.miscellaneous.constant.ValidationMessageEnum;
import com.co.app.miscellaneous.dto.GenericDto;
import com.co.app.miscellaneous.dto.MessageExceptionDto;
import com.co.app.miscellaneous.utils.ValidationMessage;
import com.co.app.miscellaneous.utils.ValidationMessageUtil;

@Log4j2
@RestControllerAdvice

public class AppExceptionHandler {

    @Autowired
    private ValidationMessageUtil validationMessageUtil;

    @ResponseBody
    @ExceptionHandler(value = ControllerPragmaException.class)
    public ResponseEntity<?> handleException(ControllerPragmaException exception) {
        log.info("[{}] Exception BusinessPragmaExcetion, mensaje: {}", Thread.currentThread().getId(), exception.getMessage());
        MessageExceptionDto exceptionDto = MessageExceptionDto.builder().build();
        exceptionDto.setData(exception.getMessage());

        return ResponseEntity.status(HttpStatus.OK).body(GenericDto.failed(exceptionDto));
    }

    @ResponseBody
    @ExceptionHandler(value = RulesException.class)
    public ResponseEntity<?> handleException(RulesException exception) {
        log.info("[{}] Exception RulesException, mensaje: {}", Thread.currentThread().getId(), exception.getMessage());
        MessageExceptionDto exceptionDto = MessageExceptionDto.builder().message(exception.getMessage()).build();

        return ResponseEntity.status(HttpStatus.OK).body(GenericDto.failed(exceptionDto));
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        exception.printStackTrace();
        log.info("[{}] Exception UnknownException, mensaje: {}", Thread.currentThread().getId(), exception.getMessage());
        MessageExceptionDto exceptionDto = ResolveMessage(ValidationMessageEnum.UnknownException);
        return ResponseEntity.status(HttpStatus.OK).body(GenericDto.failed(exceptionDto));
    }

    @ResponseBody
    private MessageExceptionDto ResolveMessage(ValidationMessageEnum messageEnum) {
        MessageExceptionDto exceptionDto = MessageExceptionDto.builder().build();
        ValidationMessage validationMessage = loadValidationMessage(messageEnum);
        exceptionDto.setValidationMessage(validationMessage);

        return exceptionDto;
    }

    private ValidationMessage loadValidationMessage(ValidationMessageEnum validationMessageEnum) {
        return validationMessageUtil.loadMessage(validationMessageEnum);
    }

}
