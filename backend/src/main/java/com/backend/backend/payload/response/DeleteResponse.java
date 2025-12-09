package com.backend.backend.payload.response;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class DeleteResponse {

    private int status;

    private String message;

    private Long userId;
}
