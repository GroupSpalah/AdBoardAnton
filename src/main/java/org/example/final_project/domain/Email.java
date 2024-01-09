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
public class Email {
    @Id
    @GeneratedValue
    @Column(name = "email_id")
    int id;

    String name;

    @OneToOne
    @JoinColumn(name = "FK_Email_Author")
    Author author;
}
