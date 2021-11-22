package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class Address extends BaseDomain {
    @Enumerated(EnumType.STRING)
    @NotNull
    Country country;//enum

    @NotBlank
    @Size(min = 2, max = 20)
    String city;

}
