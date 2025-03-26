package com.example.msemail.services;

import com.example.msemail.enums.StatusEmail;
import com.example.msemail.models.EmailModel;
import com.example.msemail.repositories.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private SesClient sesClient;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            log.info("Tentando enviar email para: {}", emailModel.getEmailTo());

            SendEmailRequest request = SendEmailRequest.builder()
                    .source(emailModel.getEmailFrom())
                    .destination(Destination.builder().toAddresses(emailModel.getEmailTo()).build())
                    .message(Message.builder()
                            .subject(Content.builder().data(emailModel.getSubject()).charset("UTF-8").build())
                            .body(Body.builder()
                                    .text(Content.builder().data(emailModel.getText()).charset("UTF-8").build())
                                    .build())
                            .build())
                    .build();

            sesClient.sendEmail(request); // Envia o email
            emailModel.setStatusEmail(StatusEmail.SENT);
            log.info("Email enviado com sucesso para: {}", emailModel.getEmailTo());

        } catch (SesException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            log.error("Falha ao enviar email para: {} - Motivo: {}", emailModel.getEmailTo(), e.awsErrorDetails().errorMessage());
        }

        return emailRepository.save(emailModel);
    }

    public Page<EmailModel> findAll(Pageable pageable) {
        return emailRepository.findAll(pageable);
    }

    public Optional<EmailModel> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
