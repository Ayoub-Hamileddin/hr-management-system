package com.backend.backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationToken {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String token;

    @OneToOne
    private User user;

    private LocalDateTime ExpireAt;

    private  boolean used;

}
