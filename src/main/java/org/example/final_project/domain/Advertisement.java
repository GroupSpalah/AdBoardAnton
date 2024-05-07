package org.example.final_project.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @Column(name = "ad_id")
    int id;

    String name;
    LocalDate date;

    @Column(name = "advert_text")
    String advertText;

    @Column(name = "price")
    BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_category")
    private Category category;

   @ManyToOne
    @JoinColumn(name = "FK_Ad_Author")
    Author author;
}
