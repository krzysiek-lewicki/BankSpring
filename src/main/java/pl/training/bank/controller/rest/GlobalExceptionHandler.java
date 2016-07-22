package pl.training.bank.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.training.bank.dto.ExceptionDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException() {
        return new ResponseEntity(new ExceptionDto(ExceptionDto.Type.APPLICATION_EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
