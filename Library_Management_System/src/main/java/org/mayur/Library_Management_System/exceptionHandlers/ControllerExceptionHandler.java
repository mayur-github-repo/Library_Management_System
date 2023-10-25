package org.mayur.Library_Management_System.exceptionHandlers;

import org.mayur.Library_Management_System.exception.TxnServiceException;
import org.mayur.Library_Management_System.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = TxnServiceException.class)
    public ResponseEntity<Object> handle(TxnServiceException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handle(MethodArgumentNotValidException e){
        GenericResponse resp =  GenericResponse.builder().
                error(e.getBindingResult().getFieldError().getDefaultMessage()).
                status(HttpStatus.BAD_REQUEST).
                build();
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Object> handle(Exception e){
//        return new ResponseEntity<>("Technical error occurred !", HttpStatus.OK);
//    }
}


