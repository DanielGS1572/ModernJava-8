package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class I_FunctionStudentExample {

    //Recibe una lista de estudiantes y regresa un mapa con su nombre y GPA cuyo getGradeLevel()>=3
    static Function<List<Student>, Map<String, Double>>  function = (students -> {

        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if(D_PredicateStudentExample.p1.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }
        }));

        return studentGradeMap;
//todo IMPORTANTE
        //ver que el return type de funciton es Function<List<Student>, Map<String, Double>>
        // y no solo el Map<String, Double>

    });

    public static void main(String[] args) {

        System.out.println(function.apply(StudentDataBase.getAllStudents()));

    }
}
