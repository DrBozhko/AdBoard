package com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static lombok.AccessLevel.PRIVATE;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class BaseDomain {
    @Id
    @Min(value = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Version
    @Column(name = "VERSION")
    @Min(value = 0)
    int version;
}
