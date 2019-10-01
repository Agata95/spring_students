package com.javagda25.spring.students.service;

import com.javagda25.spring.students.model.Grade;
import com.javagda25.spring.students.repository.GradeRepository;
import com.javagda25.spring.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
//    private final StudentRepository studentRepository;

    public List<Grade> getAllStudents() {
        return gradeRepository.findAll();
    }

    public void add(Grade grade) {
        gradeRepository.save(grade);
    }

    public Optional<Grade> findById(Long gradeId) {
        return gradeRepository.findById(gradeId);
    }

    public void delete(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
