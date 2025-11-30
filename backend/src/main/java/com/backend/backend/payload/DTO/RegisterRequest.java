package com.backend.backend.payload.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class RegisterRequest {
    @NotBlank(message = "firstName is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String lastName;
   
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email Format")
    private String email;
    
    @NotBlank(message = "Password is required")
    private String password;

}
