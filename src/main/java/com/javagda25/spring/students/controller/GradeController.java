package com.javagda25.spring.students.controller;

import com.javagda25.spring.students.model.Grade;
import com.javagda25.spring.students.model.GradeSubject;
import com.javagda25.spring.students.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/grade/")
public class GradeController {
    private final GradeService gradeService;

    //    listowane ocen:
    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Grade> gradeList = gradeService.getAllStudents();
        model.addAttribute("grades", gradeList);
        return "grade-list";
    }

    //    dodawanie oceny:
    @GetMapping(path = "/add/{studentId}")
    public String addGrade(Model model, Grade grade,
                           @PathVariable(name = "studentId") Long studentId) {
        model.addAttribute("grade", grade);
        model.addAttribute("subjects", GradeSubject.values());
        model.addAttribute("studentId", studentId);
        return "grade-add";
    }

    @PostMapping(path = "/add")
    public String add(Grade grade, Long studentParam) {
        gradeService.save(grade, studentParam);

        return "redirect:/student/list";
    }

    //    edycja ocen:
    @GetMapping(path = "/edit")
    public String edit(Model model,
                       @RequestParam(name = "id") Long gradeId) {
//        model.addAttribute("id", gradeId);
        Optional<Grade> gradeOptional = gradeService.findById(gradeId);
        if (gradeOptional.isPresent()) {
            model.addAttribute("grade", gradeOptional.get());
            model.addAttribute("subjects", GradeSubject.values());
            return "grade-add";
        }
        return "redirect:/grade/list";
    }

    //  usuwanie ocen:
    @GetMapping(path = "/delete")
    public String delete(Model model,
                         @RequestParam(name = "id") Long gradeId) {
        model.addAttribute("id", gradeId);
        gradeService.delete(gradeId);
        return "redirect:/grade/list";
    }

}
