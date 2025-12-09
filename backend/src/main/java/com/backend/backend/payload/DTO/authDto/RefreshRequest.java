package com.backend.backend.payload.DTO.authDto;

import lombok.Data;

@Data
public class RefreshRequest {
    private String token;
}
