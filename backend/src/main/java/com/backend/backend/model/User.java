package com.backend.backend.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.backend.domain.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails     {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "firstName cannot be empty")
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    private String lastName;

    @Email
    @Column(unique = true,nullable = false)
    private String email;
    
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
 
    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



    @PrePersist
    protected void createdAt() {
            createdAt=LocalDateTime.now();
    }

    @PreUpdate
    protected void updatedAt() {
            updatedAt=LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
   

    @Override
    public String getUsername() {
      return email;
    }

}
