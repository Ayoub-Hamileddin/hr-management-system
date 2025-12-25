package com.backend.backend.payload.DTO.employeeDto;


import lombok.Data;

@Data
public class SetPasswordRequest {
    private String token;
    private String password;
}
// after sending the email to active the employee acount ,
// this the dto class that contain the information to set password and active the account employee