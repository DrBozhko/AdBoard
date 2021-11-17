package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    @Column(name = "email_id")
    int id;

    @Version
    @Min(value = 0)
    @Column(name = "VERSION")
    int version;

    @NotBlank
    @Size(min = 2, max = 20)
    String name;
}
