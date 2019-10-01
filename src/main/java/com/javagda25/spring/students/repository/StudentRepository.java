package com.javagda25.spring.students.repository;

import com.javagda25.spring.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Student - klasa z której korzystamy, Long - od typu ID (identyfikator) z klasy Student
// można dodać @Repository, ale ta klasa rozszerza już klasę, która jest komponentem,
// zatem nie jest konieczne aby to dodawać
public interface StudentRepository extends JpaRepository<Student,Long> {
}
