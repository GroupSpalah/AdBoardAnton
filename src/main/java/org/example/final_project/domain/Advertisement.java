package org.example.final_project.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Advertisement {
    @Id
    @GeneratedValue
    @Column(name = "advertisement_id")
    int id;

    String name;
    LocalDate date;

    String advertText;
    double cost;

 @ManyToOne
    @JoinColumn(name = "FK_Advertisement_Category")
    Category category;
}
