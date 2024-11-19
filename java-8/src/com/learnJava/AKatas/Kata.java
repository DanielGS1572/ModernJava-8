package com.learnJava.AKatas;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    static Predicate<Student> p1 = s -> s.getGpa()>=3.9;
    public static void main(String args[]){
        StudentDataBase.getAllStudents().forEach(s -> {
            if(p1.test(s)){
                System.out.println(s.getName());
            }
        });

        System.out.println(StudentDataBase.getAllStudents().stream().filter(p1).collect(Collectors.toList()));;
    }

}
