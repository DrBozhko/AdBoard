package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class Rubric {
    @Id
    @Min(value = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rubric_id")
    int id;

    @Version
    @Min(value = 0)
    @Column(name = "VERSION")
    int version;

    @NotBlank
    @Size(min = 2, max = 20)
    String name;

}
