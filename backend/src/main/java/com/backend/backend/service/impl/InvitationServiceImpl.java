package com.backend.backend.service.impl;

import com.backend.backend.model.InvitationToken;
import com.backend.backend.model.User;
import com.backend.backend.repository.InvitationTokenRepository;
import com.backend.backend.service.EmailService;
import com.backend.backend.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InvitationTokenRepository tokenRepository;
    private final EmailService  emailService;

    @Override
    public void sendInvitation(User user) {
        String token= UUID.randomUUID().toString();

        InvitationToken invitationToken=InvitationToken.builder()
                    .token(token)
                    .user(user)
                    .ExpireAt(LocalDateTime.now().plusHours(24))
                    .used(false)
                .build();

        tokenRepository.save(invitationToken);

        String link="http://localhost:3000/set-password?token ="+ token   ;

        emailService.send(
                user.getEmail(),
                "activate your account",
                "click here to reset the password" + link
        );

    }
}
