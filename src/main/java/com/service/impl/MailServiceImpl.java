package com.service.impl;

import com.domain.Advertisement;
import com.repository.MailRepository;
import com.service.MailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    MailRepository repository;

    JavaMailSender sender;

    @Override
    public void sendMails(Advertisement ad) {
        List<String> mails = repository.findSuitableMails(ad.getCost(), ad.getRubric().getName(), ad.getName());

        SimpleMailMessage message = new SimpleMailMessage();

        String[] temp = new String[mails.size()];

        String[] posts = mails.toArray(temp);

        message.setTo(posts);
        message.setSubject("New ad for you");
        String text = ad.getName()
                .concat("\t")
                .concat(ad.getText());
        message.setText(text);

        sender.send(message);

    }
}
