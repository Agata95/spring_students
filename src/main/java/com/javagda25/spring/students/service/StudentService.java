package com.javagda25.spring.students.service;

import com.javagda25.spring.students.model.Student;
import com.javagda25.spring.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

//    tworzy się singleton
//    @Autowired dodaje się do pola studentRepository
//    ale lepiej wygląda, gdy pole to określa się jako finalne i ustawia się @AllArgsConstructor

    private final StudentRepository studentRepository;

//    wszystkie poniższe meteody zawarte są w studentReposotory, która rozszerza JpaRepository

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
