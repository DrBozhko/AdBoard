package com.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Objects;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = {"author"})
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0)
    @Column(name = "phone_id")
    int id;

    @Version
    @Min(value = 0)
    @Column(name = "VERSION")
    int version;

    @NotBlank
    @Size(min = 2, max = 20)
    String number;

    @ManyToOne
    @JoinColumn(name = "FK_Phone_Author")
    Author author;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Phone phone = (Phone) o;
//        return id == phone.id &&
//                version == phone.version &&
//                Objects.equals(number, phone.number);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, version, number);
//    }
}
