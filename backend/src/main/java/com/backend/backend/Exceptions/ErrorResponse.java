package com.backend.backend.Exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ErrorResponse {

    private boolean success;

    private int status;

    private String error_code;

    private  String message ;

    private List<FieldsError> errors;

    private LocalDateTime timestamp;

    private String path;
    
}



