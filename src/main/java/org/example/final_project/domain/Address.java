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
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    int id;

     String country;
     String city;


    @OneToOne
    @JoinColumn(name = "FK_Address_Author")
    Author author;
}
