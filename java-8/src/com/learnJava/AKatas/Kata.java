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
    static Predicate<Student> gpa4 = s -> s.getGpa() >= 4;
    static Predicate<Student> notebookes15 = s -> s.getNoteBooks() >= 15;

    public static void main(String[] args){
        List<Student> studentList = StudentDataBase.getAllStudents();
        /*studentList.forEach(student -> {
            if(gpa4.or(notebookes15).test(student)){
                System.out.println(student.getName());
            }
        });*/
        System.out.println(studentList.stream().filter(gpa4.and(notebookes15)).collect(Collectors.toList()));
    }

}
