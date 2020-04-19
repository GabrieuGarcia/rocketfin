package com.rocketfin.exception.handler;

import com.rocketfin.exception.ResourceNotFoundException;
import com.rocketfin.exception.details.ResourceNotFoundDetails;
import com.rocketfin.exception.details.ValidationErrorDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException){
         ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .title("Resource not found")
                .timestamp(new Date().getTime())
                .detail(rnfException.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .message(rnfException.getClass().getName())
                .build();

         return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentoNotValidException(MethodArgumentNotValidException manvException){

        LOGGER.info("MethodArgumentNotValidException: {}",  manvException.getBindingResult().getFieldErrors());

        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        ValidationErrorDetail validationErrorDetail = ValidationErrorDetail.Builder
                .newBuilder()
                .title("Field not valid")
                .timestamp(new Date().getTime())
                .detail("Field not valid")
                .status(HttpStatus.BAD_REQUEST.value())
                .message(manvException.getClass().getName())
                .field(fields)
                .fieldMessage(fieldsMessage)
                .build();

        return new ResponseEntity<>(validationErrorDetail, HttpStatus.BAD_REQUEST);
    }

}
