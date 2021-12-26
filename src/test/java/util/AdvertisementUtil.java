package util;

import com.domain.Advertisement;
import com.domain.Author;
import com.domain.Rubric;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AdvertisementUtil {
    public static Advertisement getAdvertisement() {
        Author author = AuthorUtil.getAuthor();
        Rubric rubric = RubricUtil.getRubric();

        return Advertisement.builder()
                .id(0)
                .version(0)
                .name("Dogs")
                .publication(LocalDate.of(2000,2,5))
                .text("Test text")
                .cost(BigDecimal.valueOf(50))
                .author(author)
                .rubric(rubric)
                .build();
    }
}
