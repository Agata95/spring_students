package com.javagda25.spring.students.repository;

import com.javagda25.spring.students.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
