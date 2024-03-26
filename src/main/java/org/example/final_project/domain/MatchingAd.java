package org.example.final_project.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class MatchingAd {
    @Id
    @GeneratedValue
    @Column(name = "matchAd_id")
    int id;

    BigDecimal priceFrom;
    BigDecimal priceTo;
    String title;

    @ManyToOne
    @JoinColumn(name = "FK_matchAd_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_matchAd_Category")
    Category category;
}
