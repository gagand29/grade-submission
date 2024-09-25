package com.gagan.grade_submission.repository;

import java.util.ArrayList;
import java.util.List;

import com.gagan.grade_submission.Grade;

public class GradeRepository {
   
   private List<Grade> StudentGrades = new ArrayList<>();

   public Grade getGrade(int index) {
    return StudentGrades.get(index);
   }

   public void addGrade(Grade grade) {
    StudentGrades.add(grade);

   }

   public void updateGrade(Grade grade, int index) {
   StudentGrades.set(index, grade);
}

    public List<Grade> getGrades(){
        return StudentGrades;
    }

    
}
