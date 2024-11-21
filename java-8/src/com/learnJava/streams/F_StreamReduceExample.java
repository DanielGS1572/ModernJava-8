package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class F_StreamReduceExample {
/*
.reduce es una operación terminal, lo que significa que va al final del lambda y cierra el lambda para ya no ser usado después

Toma dos parametros como entrada
First parameterS - valor default o inicial
Second parameteR - BinaryOperator<T>

Recordar que binaryOperator es un (T Function<T,T>) recibe dos inputs del mismo tipo y regresa un elemento de ese tipo

Su principal objetivo es reducir todos los elementos del stream en un solo valor
por ejemplo, sacar la suma, multiplicación o el elemento más grande se una lista
*/
    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b  /*accumulator.- ira acumulando los calculos*/); // performs multiplication for each element in the stream and returns a new result fo.

        /*
        [A]
        - 1
        - 3
        - 5
        - 7

        a=1, b=1 = 1            a es el valor inicial y b es la lista que se le pasa como parametro
        a=1, b=3 = 3            a es el resultado anterior y b es el siguiente número como parametro
        a=3, b=5 = 15           a es el resultado anterior y b es el siguiente número como parametro
        a=15, b=7 = 105         a es el resultado anterior y b es el siguiente número como parametro
        */
    }

    public static String combineStudentNames(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .reduce("",(a,b) -> a.concat(b));  // performs multiplication for each element in the stream.
    }

    public static Optional<Student> getHighestGradeStudent(){

        Optional<Student> studentOptional =  StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
        return studentOptional;
    }




    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,3,5,7);
        //List<Integer> integerList = Arrays.asList();

        System.out.println("Result is : " + performMultiplication(integerList));        //[A]
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }

        System.out.println(combineStudentNames());
        System.out.println(getHighestGradeStudent().get());
    }
}
