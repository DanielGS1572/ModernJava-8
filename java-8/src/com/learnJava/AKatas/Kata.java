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
    static BiConsumer<String,List<String>> c1 = (s1,s2) -> System.out.println(s1 + " : " + s2);
    static BiConsumer<Integer,Integer> suma = (n1,n2)-> System.out.println(n1+n2);
    static BiConsumer<Integer,Integer> multiplicacion = (n1,n2)-> System.out.println(n1*n2);
    static BiConsumer<Integer,Integer> division = (n1,n2)-> System.out.println(n1/n2);

    public static void main(String[] args){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student->{
            c1.accept(student.getName(),student.getActivities());
        });
    }

}
