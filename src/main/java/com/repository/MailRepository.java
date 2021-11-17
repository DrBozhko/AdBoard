package com.repository;

import com.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Integer> {
    @Query("SELECT em.name " +
            "FROM MatchingAd mad " +
            "JOIN mad.author au " +
            "JOIN au.email em " +
            "WHERE :price BETWEEN mad.priceFrom AND mad.priceTo " +
            "AND mad.rubric.name = :category " +
            "AND :title LIKE CONCAT('%', mad.title, '%')")
    List<String> findSuitableMails(@Param("price") BigDecimal price,
                                          @Param("category") String categoryName,
                                          @Param("title") String title);
}
