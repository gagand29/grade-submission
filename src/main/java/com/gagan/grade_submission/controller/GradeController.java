package com.gagan.grade_submission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

import com.gagan.grade_submission.Grade;
import com.gagan.grade_submission.service.GradeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
       model.addAttribute("grade", gradeService.getGradeById(id));

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade , BindingResult result) {
        System.out.println("Has errors?: " + result.hasErrors());
        if(result.hasErrors())
        {
            return "form";
        }
        System.out.println(grade.getSubject());
        System.out.println(grade.getName());

        gradeService.submitGrade(grade);
        
        return "redirect:/grades";
    }
    

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }
    
}
