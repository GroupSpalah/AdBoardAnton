package org.example.final_project.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Phone {
    @Id
    @GeneratedValue
    @Column(name = "phone_id")
    int id;

    String number;

    @OneToOne
    @JoinColumn(name = "FK_Phone_Author")
    Author author;
}
