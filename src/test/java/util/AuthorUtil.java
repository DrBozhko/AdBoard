package util;

import com.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AuthorUtil {
    public static Author getAuthor() {
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

        return author;
    }
}
