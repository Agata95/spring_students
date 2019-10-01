package com.javagda25.spring.students.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity // to jest encja bazodanowa
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String surname;

    private int age; // "not null"
    private boolean alive; // "not null"

    @Formula(value = "(SELECT AVG(g.value) FROM Grade g WHERE g.student_id = id)")
    private Double average; // nullable - nie ma "not null"

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE})
    private Set<Grade> gradeList;

    public Student(String name, String surname, int age, boolean alive) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.alive = alive;
    }
    public Student(Long id, String name, String surname, int age, boolean alive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.alive = alive;
    }
}
