package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class MatchingAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0)
    @Column(name = "mad_id")
    int id;

    @Version
    @Min(value = 0)
    @Column(name = "VERSION")
    int version;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Rubric")
    Rubric rubric;

    @Max(value = 10000)
    BigDecimal priceFrom;

    @Max(value = 10000)
    BigDecimal priceTo;

    @NotBlank
    @Size(min = 2, max = 20)
    String title;
}
