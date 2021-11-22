package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.Year;
import java.util.List;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class Author extends BaseDomain {
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true,
            mappedBy = "author")
    List<@NotNull Phone> phones;

    @Valid
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_Author_Address")
    @NotNull Address address;

    @NotBlank
    @Size(min = 2, max = 20)
    String name;

    @Valid
    @NotNull
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_Author_Email")
    Mail email;


}
