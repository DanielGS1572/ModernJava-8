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
    Function
    Supplier
    Predicate.- Recibe un objeto y regresa un booleano
    */

    static Function<List<Student>,Map<String,Integer>> f1 = students -> {
        Map<String,Integer> mapStudent=new HashMap<>();
      students.forEach(student -> {
          mapStudent.put(student.getName(), student.getGradeLevel());
      });
        return mapStudent;

    };
    public static void main(String[] args) {
        System.out.println(f1.apply(StudentDataBase.getAllStudents()));
    }

}
