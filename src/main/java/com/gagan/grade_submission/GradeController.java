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
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        int index=getGradeIndex(id);
       model.addAttribute("grade", index== Constants.NOT_FOUND  ? new Grade(): StudentGrades.get(index));

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if(index== Constants.NOT_FOUND)
        {
            StudentGrades.add(grade);
        }
        else{
            StudentGrades.set(index,grade);
        }
        
        return "redirect:/grades";
    }
    
    

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", StudentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String id){
        for(int i=0; i< StudentGrades.size();i++)
        {
            if(StudentGrades.get(i).getId().equals(id))
            return i;
        }
        return Constants.NOT_FOUND;
    }
}
