package com;

import com.config.ConfigApp;
import com.service.impl.AdvertisementServiceImpl;
import com.service.impl.AuthorServiceImpl;
import com.service.impl.RubricServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAd {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        AuthorServiceImpl authorService = context.getBean(AuthorServiceImpl.class);
        AdvertisementServiceImpl advertisementService = context.getBean(AdvertisementServiceImpl.class);
        RubricServiceImpl rubricService = context.getBean(RubricServiceImpl.class);
    }
}
