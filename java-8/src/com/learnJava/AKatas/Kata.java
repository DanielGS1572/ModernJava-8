package com.learnJava.AKatas;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    /*
    Consumer
    supplier
    function
    predicate
    */
    static Predicate <Student> p1 = student -> student.getGradeLevel()>=3;
    static Function<List<Student>, Map<String, Double>> f1 = list -> {

        Map<String, Double> map = new HashMap<>();

        list.forEach(s -> {
            if (p1.test(s)) {
                map.put(s.getName(), s.getGpa());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        System.out.println(f1.apply(StudentDataBase.getAllStudents()));
    }
}
