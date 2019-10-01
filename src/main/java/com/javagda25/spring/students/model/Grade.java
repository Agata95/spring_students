package com.javagda25.spring.students.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

//    przy update pole dateAdded nie będzie brane pod uwagę
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateAdded;
    private double value;

    @ToString.Exclude
    @ManyToOne()
    private Student student;
    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }
}
