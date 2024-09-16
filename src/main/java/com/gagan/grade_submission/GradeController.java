package com.gagan.grade_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    // Initialize the list with Arrays.asList
    List<Grade> StudentGrades = new ArrayList<>(Arrays.asList(
            new Grade("Gagan", "Potions", "C-"),
            new Grade("Anshuman", "Potions", "B-"),
            new Grade("Megha", "Potions", "Z-")
    ));

    @GetMapping("/grades")
    public String getGrades(Model model) {
        
      

        model.addAttribute("grades", StudentGrades);
        return "grades";
    }
}
