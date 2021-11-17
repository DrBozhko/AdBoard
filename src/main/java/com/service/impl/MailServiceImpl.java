package com.service.impl;

import com.domain.Advertisement;
import com.repository.MailRepository;
import com.service.MailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    MailRepository repository;

    @Override
    public void sendMails(Advertisement ad) {
        List<String> mails = repository.findSuitableMails(ad.getCost(), ad.getRubric().getName(), ad.getName());

        System.out.println();
    }
}
