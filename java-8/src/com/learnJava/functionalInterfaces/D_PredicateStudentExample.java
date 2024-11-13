package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class D_PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    /*
    TODO importante:
    En lugar de hardcodear las condiciones en un predicate con operadores logicos (&& por ejemplo)
    se puede jugar con .and .or

     */

    static Function<Integer,Predicate<Integer>> gradePredicate = (toCompare) -> (number) -> number > toCompare;
    static Function<Double,Predicate<Double>>  gpaPredicate = (toCompare) -> (number) -> number > toCompare;


    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();
//ForEach with consumer
        studentList.forEach((student -> {
            //con p1 se esta validando que GPA sea >=3.9
            //en lugar de poner las condiciones como en A_ConsumerExample ~ Linea60
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
//filter with Predicate (menos verboso)
//ver que filter tiene sentido que reciba un predicate para decir si va o no va
        studentList.stream()
                .filter(p1)
                .collect(Collectors.toList());



        boolean result = gradePredicate.apply(2).test(5) && gpaPredicate.apply(3.6).test(3.9);
        System.out.println("Result from Predicate : " + result);

    }
}
