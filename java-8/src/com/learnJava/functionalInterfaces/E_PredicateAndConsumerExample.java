package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E_PredicateAndConsumerExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;
//Ver que puede ser static o no (dos lineas pasadas + linea siguiente)
    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer = (student) -> {

        if(p1.and(p2).test(student)){  //Predicate para GradeLevel y GPA
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    };


    public void printNameandActivities(List<Student> studentList){
        studentList.forEach(studentConsumer);               //recordar que el forEach recibe un consumer e internamente hace el .accept
                                                            //ver que ademas dentro del consumer utiliza predicta y un biConsumer
    }

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        new E_PredicateAndConsumerExample().printNameandActivities(studentList);

    }
}
