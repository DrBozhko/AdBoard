package com;

import com.config.ConfigApp;
import com.domain.*;
import com.service.AdvertisementService;
import com.service.impl.AuthorServiceImpl;
import com.service.impl.MadServiceImpl;
import com.service.impl.RubricServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestAdsBoard {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        AdvertisementService aService = context.getBean(AdvertisementService.class);
        AuthorServiceImpl authorService = context.getBean(AuthorServiceImpl.class);
        RubricServiceImpl rubricService = context.getBean(RubricServiceImpl.class);

        Phone phone1 = Phone.builder().number("+38012").build();
        Phone phone2 = Phone.builder().number("+38013").build();
        List<Phone> phones = Arrays.asList(phone1, phone2);

        Phone phone3 = Phone.builder().number("+38066").build();
        Phone phone4 = Phone.builder().number("+38077").build();
        List<Phone> phones2 = Arrays.asList(phone3, phone4);

        Phone phone5 = Phone.builder().number("+38888").build();
        Phone phone6 = Phone.builder().number("+38999").build();
        List<Phone> phones3 = Arrays.asList(phone5, phone6);


        Address ua = Address.builder().country(Country.UA).city("Od").build();
        Address uk = Address.builder().country(Country.UK).city("Ln").build();
        Address us = Address.builder().country(Country.US).city("NY").build();

        Mail googleMail = Mail.builder().name("drbozhko@gmail.com").build();
        Mail yahooMail = Mail.builder().name("drbozhko@yahoo.com").build();
        Mail protonMail = Mail.builder().name("drbozhko@proton.com").build();



        Author author = Author.builder()
                .phones(phones)
                .address(ua)
                .name("Alex")
                .email(googleMail)
                .build();

        Author author2 = Author.builder()
                .phones(phones2)
                .address(uk)
                .name("Oleg")
                .email(yahooMail)
                .build();

        Author author3 = Author.builder()
                .phones(phones3)
                .address(us)
                .name("Daniel")
                .email(protonMail)
                .build();

        Rubric rubric = Rubric.builder()
                .name("Unusual Name")
                .build();

        Rubric rubric2 = Rubric.builder()
                .name("Usual Name")
                .build();

        Rubric rubric3 = Rubric.builder()
                .name("Test Name")
                .build();

//        authorService.save(author);
//        rubricService.save(rubric);
//        authorService.save(author2);
//        authorService.save(author3);
//        rubricService.save(rubric2);
//        rubricService.save(rubric3);

//        Author authorFound = authorService.findById(4);
//        Rubric rubricFound = rubricService.findById(1);
//
//        Author authorFound2 = authorService.findById(15);
//        Rubric rubricFound2 = rubricService.findById(3);
//
//        MatchingAd matchingAd = MatchingAd.builder()
//                .author(authorFound)
//                .rubric(rubricFound)
//                .priceFrom(BigDecimal.valueOf(100))
//                .priceTo(BigDecimal.valueOf(1000))
//                .title("pcs")
//                .build();
//
//        MatchingAd matchingAd2 = MatchingAd.builder()
//                .author(authorFound2)
//                .rubric(rubricFound2)
//                .priceFrom(BigDecimal.valueOf(100))
//                .priceTo(BigDecimal.valueOf(1000))
//                .title("autos")
//                .build();

//        MadServiceImpl madService = context.getBean(MadServiceImpl.class);
//        madService.save(matchingAd);
//        madService.save(matchingAd2);

        Author authorFound = authorService.findById(4);
        Rubric rubricFound = rubricService.findById(1);

//        Author authorFound2 = authorService.findById(15);
//        Rubric rubricFound2 = rubricService.findById(3);
//
//        Author authorFound3 = authorService.findById(33);
//        Rubric rubricFound3 = rubricService.findById(39);

        Advertisement advertisement = Advertisement.builder()
                .name("Buy pcs new")
                .publication(LocalDate.now())
                .text("First")
                .cost(new BigDecimal(250))
                .author(authorFound)
                .rubric(rubricFound)
                .build();

//        Advertisement advertisement2 = Advertisement.builder()
//                .name("Second")
//                .publication(LocalDate.now())
//                .text("Just a text")
//                .cost(new BigDecimal(30))
//                .author(authorFound2)
//                .rubric(rubricFound2)
//                .build();
//
//        Advertisement advertisement3 = Advertisement.builder()
//                .name("Third")
//                .publication(LocalDate.now())
//                .text("Not enough text")
//                .cost(new BigDecimal(20))
//                .author(authorFound3)
//                .rubric(rubricFound3)
//                .build();

        aService.save(advertisement);
//        aService.save(advertisement2);
//        aService.save(advertisement3);
    }
}
