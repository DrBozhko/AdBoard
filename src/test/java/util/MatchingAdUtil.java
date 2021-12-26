package util;

import com.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MatchingAdUtil {
    public static MatchingAd getMatchingAd() {
        Rubric car = Rubric.builder()
                .id(0)
                .name("Car")
                .version(0)
                .build();

        Address address = Address.builder()
                .id(0)
                .version(0)
                .country(Country.UA)
                .city("OD")
                .build();

        Mail mail = Mail.builder()
                .id(0)
                .version(0)
                .name("drbozhko@gmail.com")
                .build();

        Phone phone = Phone.builder()
                .id(0)
                .version(0)
                .number("+068")
                .author(null)
                .build();

        Phone phone2 = Phone.builder()
                .id(0)
                .version(0)
                .number("+093")
                .author(null)
                .build();

        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        phones.add(phone2);

        Author author = Author.builder()
                .id(0)
                .name("Johny")
                .version(0)
                .address(address)
                .email(mail)
                .phones(phones)
                .build();

        phone.setAuthor(author);
        phone2.setAuthor(author);

        MatchingAd matchingAd = MatchingAd.builder()
                .id(0)
                .version(0)
                .title("MADTest")
                .priceTo(BigDecimal.valueOf(200))
                .priceFrom(BigDecimal.valueOf(20))
                .rubric(car)
                .author(author)
                .build();

        return matchingAd;
    }
}
