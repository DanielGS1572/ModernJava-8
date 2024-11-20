package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A_StreamsExample {
    /*
    - Streams operation pueden ejecutarse en secuencia o paralelamente
        names.stream()
        names.parallelStream()
     */

    public static void main(String[] args) {

        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

/*
        List<String> names = Arrays.asList("adam","dan","jenny");
        names.stream();
        names.parallelStream();
        StudentDataBase.getAllStudents().stream();
        StudentDataBase.getAllStudents().parallelStream();
*/

/*CASO1*/
        System.out.println("CASO1");
        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().stream(). //.parallelStream dont forger.
                filter(gpaPredicate). // Stream<Student>
                filter(gradePredicate)
                .collect(Collectors.toMap(Student::getName ,Student::getActivities ));

        System.out.println("studentMap  : " + studentMap);

        System.out.println();
        System.out.println("CASO2");
//simplemente trata de demostrar que es una secuencia de streams y al final una operación final (collect)

        List<String> studentActivities = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .map(Student::getActivities) //<Stream<List<Activites>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() //Stream removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        /*
        TODO - Teoria => VER: src\resources\CollectionsVsStreams.png y CollectionsVsStreams2.png
         * Streams no puede modificar elementos en el stream, tiene una cantidad fija (fixed) de datos
         * Streams solo pueden ser accedidos como van llegando en secuencia
         * Streams son construidos "lazily" y Collections Eagerly
         * Streams can be traversed only once   -> ver [A] de A1_CollectionsvsStreams

         lazily.- significa que se tiene que tener operaciones terminales para poder hacer acciones
         eagerly.- imprime todo por la implementacion de .toString por ejemplo
         Ver: LazilyVSEagerly.png


        */
        System.out.println();
        System.out.println("CASO3");

        //Lo importante de este ejercicio con peek es para ver como se pasan los resultados de una operación a otra
        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((student -> {         //acepta un consumer
                    System.out.println("first operation " + student);
                }))
                .map(Student::getName) //<Stream<List<Activites>>
                .peek(a->System.out.println("second operation" + a))// todopara ver los estudiantes que son pasados a la cadena
                .distinct() // removes duplicates
                .peek(a->System.out.println("3rd operation" + a))
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);


    }
}
