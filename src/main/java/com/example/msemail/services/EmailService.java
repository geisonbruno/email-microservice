package com.example.msemail.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private AmazonSimpleEmailService sesClient;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            log.info("Tentando enviar email para: " + emailModel.getEmailTo());

            SendEmailRequest request = new SendEmailRequest()
                    .withSource(emailModel.getEmailFrom())
                    .withDestination(new Destination().withToAddresses(emailModel.getEmailTo()))
                    .withMessage(new Message()
                            .withSubject(new Content().withCharset("UTF-8").withData(emailModel.getSubject()))
                            .withBody(new Body()
                                    .withText(new Content().withCharset("UTF-8").withData(emailModel.getText()))
                            )
                    );

            sesClient.sendEmail(request);
            emailModel.setStatusEmail(StatusEmail.SENT);
            log.info("Email enviado com sucesso para: " + emailModel.getEmailTo());

        } catch (Exception e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            log.error("Falha ao enviar email para: " + emailModel.getEmailTo(), e);
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
