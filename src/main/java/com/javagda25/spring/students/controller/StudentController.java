package com.javagda25.spring.students.controller;

import com.javagda25.spring.students.model.Student;
import com.javagda25.spring.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/student/")
public class StudentController {
    private final StudentService studentService;

    //    dodawanie studenta:
    //    najpierw przekazujemy pusty obiekt Student
    @GetMapping(path = "/add")
    public String add(Model model, Student student) {
        model.addAttribute("student", student);
        return "student-add";
    }

    //    uzupełniamy obiekt Student
    @PostMapping(path = "/add")
    public String add(Student student) {
        studentService.add(student);
        return "redirect:/student/list";
    }

    //    listowanie studentów:
    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        return "student-list";
    }

    //    edycja Studenta (sposób pierwszy):
    @GetMapping("/edit/{edited_student_id}")
    public String edit(Model model,
                       @PathVariable(name = "edited_student_id") Long studentId) {
        return editStudent(model, studentId);
    }

    private String editStudent(Model model,
                               @PathVariable(name = "edited_student_id") Long studentId) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "student-add";
        }
        return "redirect:/student/list";
    }

    //    edycja Studenta (sposób drugi):
    @GetMapping(path = "/edit")
    public String edit2(Model model,
                       @RequestParam(name = "id") Long studentId) {
        return editStudent(model, studentId);
    }

    //    usuwanie Studenta (sposób pierwszy):
    @GetMapping("/delete/{deleted_student_id}")
    public String delete(@PathVariable(name = "deleted_student_id") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }

    //    usuwanie Studenta (sposób drugi):
    @GetMapping(path = "/delete")
    public String delete2(Model model,
                          @RequestParam(name = "id") Long studentId) {
            model.addAttribute("id", studentId);
            studentService.delete(studentId);
        return "redirect:/student/list";
    }

}
