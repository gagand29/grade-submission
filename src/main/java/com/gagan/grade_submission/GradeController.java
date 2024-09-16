package com.gagan.grade_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class GradeController {

    // Initialize the list with Arrays.asList
    List<Grade> StudentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        StudentGrades.add(grade);
        return "redirect:/grades";
    }
    
    

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", StudentGrades);
        return "grades";
    }
}
