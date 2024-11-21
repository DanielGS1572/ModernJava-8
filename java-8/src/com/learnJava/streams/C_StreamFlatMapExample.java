package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class C_StreamFlatMapExample {
/*
Funciona como .map() pero donde cada elemento representa multiples elementos:
- Stream<List>
- Stream<Arrays>
PUEDE SER CUALQUIER TIPO DE COLLECTION QUE REPRESENTA DIFERENTES ELEMENTOS


*/
    public static List<String> printStudentActivities() {
//Imprimir toda la lista de activities
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()//Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String> ... ver que esto es como (<List<String>>)lista.stream donde <List<String>> es el paso anterior
                .collect(toList());

        return studentActivities;

    }

    /*
    - distinct
    - count
    - sorted
    */
    public static List<String> printUniqueStudentActivities() {

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());

        return studentActivities;

    }

    public static long getStudentActivitiesCount() {

        long totalActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        return totalActivities;

    }

    public static void main(String[] args) {


        System.out.println("Student Activities : " + printStudentActivities());
        System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
        System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());

    }

}
