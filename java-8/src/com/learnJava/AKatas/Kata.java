package com.learnJava.AKatas;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    static Consumer<String> c1 = (s)-> System.out.println(s.toUpperCase());
    static Consumer<Student> c2 = student -> System.out.println(student);
    static Consumer<Student> c3 = student -> System.out.print(student.getName().toUpperCase());
    static Consumer<Student> c4 = student -> System.out.println(student.getActivities());
    public static void main(String[] args){

        StudentDataBase.getAllStudents().forEach(s->{
            if(s.getGradeLevel() ==4 && s.getGpa()==3.9){
                c3.andThen(c2).accept(s);
            }
        });
    }
}
