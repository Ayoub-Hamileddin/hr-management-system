package com.backend.backend.model;

import com.backend.backend.domain.ApplicantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(nullable = false)
    private String positionApplied;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicantStatus status;

    private String resumeUrl;

    private LocalDate appliedDate;
}
