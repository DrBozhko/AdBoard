package com.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@FieldDefaults(level = PRIVATE)
public class Advertisement extends BaseDomain {

    @NotBlank
    @Size(min = 2, max = 20)
    String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @PastOrPresent
    LocalDate publication;

    @NotBlank
    @Size(min = 2, max = 20)
    String text;

    @NotNull
    @Max(10000)
    BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "FK_Advert_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Advert_Rubric")
    Rubric rubric;

}
