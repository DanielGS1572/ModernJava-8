package com.learnJava.AKatas;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
        static BiPredicate<Integer,Double> p1 = (g1,g2) -> g1 >=3 && g2 >= 3.9;
        static BiConsumer<String, List<String>> b1 = (s1,s2) -> System.out.println(s1 + ":" + s2);

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(s -> {
            if(p1.test(s.getGradeLevel(),s.getGpa())){
                b1.accept(s.getName(),s.getActivities());
            }
        });
    }


}
