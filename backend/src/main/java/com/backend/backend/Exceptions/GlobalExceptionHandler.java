package com.backend.backend.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleEmailExists(EmailAlreadyExistException emailAlreadyExistException,
                                                                HttpServletRequest request){
  

            return buildErrorResponse(false,HttpStatus.CONFLICT,"EMAIL_ALREADY_EXISTS","email",emailAlreadyExistException.getMessage(),request)  ;
                                                  
        }



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException notFoundException,
                                                                HttpServletRequest request){


            return buildErrorResponse(false,HttpStatus.NOT_FOUND,"RESSOURCE_NOT_FOUND",notFoundException.getField(),notFoundException.getMessage(),request)  ;
                                                    
        }





    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException badRequestException,
                                                                HttpServletRequest request){


                return buildErrorResponse(false,HttpStatus.BAD_REQUEST,"BAD_REQUEST","client",badRequestException.getMessage(),request)  ;
                                                   
        }





    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException unauthorizedException,
                                                                HttpServletRequest request){
   

            return buildErrorResponse(false,HttpStatus.UNAUTHORIZED,"UNAUTHORIZED","user",unauthorizedException.getMessage(),request)  ;
                                                  
        }





    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(ConflictException conflictException,
                                                                HttpServletRequest request){


            return buildErrorResponse(false,HttpStatus.CONFLICT,"CONFLICT","",conflictException.getMessage(),request)  ;

        }


        


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleArgumentNotValidException(MethodArgumentNotValidException argumentNotValidException,
                                                                HttpServletRequest request){

            List<FieldsError> fieldsErrors= argumentNotValidException.getBindingResult().getFieldErrors().stream()
                                          .map(error->
                                                FieldsError.builder()
                                                    .field(error.getField())
                                                    .message(error.getDefaultMessage())
                                                .build()
                                          ).toList();

            ErrorResponse err=ErrorResponse.builder()
                    .success(false)
                    .status(HttpStatus.BAD_REQUEST.value())   
                    .error_code("CONFLICT")
                    .message(argumentNotValidException.getMessage())
                    .errors(fieldsErrors)
                    .timestamp(LocalDateTime.now())
                    .path(request.getRequestURI())
                .build();    

            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(err);                                                    
        }



   
        private ResponseEntity<ErrorResponse> buildErrorResponse(
            boolean isSuccess,
            HttpStatus httpStatus,
            String error_code,
            String field,
            String message,
            HttpServletRequest request

        ){
            FieldsError fieldsErrors=FieldsError.builder()
                .field(field)
                .message(message)

            .build();


           
            
             ErrorResponse err=ErrorResponse.builder()
                    .success(isSuccess)
                    .status(httpStatus.value())   
                    .error_code(error_code)
                    .message(message)
                    .errors(List.of(fieldsErrors))
                    .timestamp(LocalDateTime.now())
                    .path(request.getRequestURI())
                .build();    

            return ResponseEntity
                .status(httpStatus.value())
                .body(err);  
        }

}
