package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class J_BiFunctionExample {
//Bifunction puede recibir dos parametros y retrona un valor (3er elemento)
    //la unica función por defaulta es andThen
    private static Map<String, String> loginPageLocs = new HashMap<>();


    static BiFunction<List<Student>,Predicate<Student>,Map<String, Double>> biFunction = (students,studentPredicate)->{

        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if(studentPredicate.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }
        }));

        return studentGradeMap;

    };

    public static String getLoginLocs(String sLocator, String elementType) {

        return loginPageLocs.get(elementType);
    }

    static BiFunction<String,String,String> getLoginLocs = (sLocator,elementType) -> loginPageLocs.get(sLocator);

    public static void main(String[] args) {

        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), D_PredicateStudentExample.p2));

        getLoginLocs.apply("locator","elementType");

    }
}
