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

Toma dos parametros como entrada[A]/O puede recibir un solo parametro[B]
First parameterS - valor default o inicial
Second parameteR - BinaryOperator<T>

Recordar que binaryOperator es un (T Function<T,T>) recibe dos inputs del mismo tipo y regresa un elemento de ese tipo

Su principal objetivo es reducir todos los elementos del stream en un solo valor
por ejemplo, sacar la suma, multiplicación o el elemento más grande se una lista
*/

    //[A]
    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
                .reduce(1, (a,b) -> a*b /*accumulator.- ira acumulando los calculos*/);     // performs multiplication for each element in the stream and returns a new result fo.

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

    //[B]
    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b );    /*Ver que lo que regresa es OPTIONAL*/
        //VER QUE OPTIONAL TIENE LA OPCION DE VER SI HAY RESULTADO O NO => result.isPresent(), EN LUGAR DE VALIDAR SI ES NULL


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

        //***************************************  [A] INICIO *************************************
        System.out.println("performMultiplication");
        List<Integer> integerList = Arrays.asList(2,3,5,7);
        //List<Integer> integerList = Arrays.asList();

        System.out.println("Result is : " + performMultiplication(integerList));
        System.out.println();
        //***************************************  [A] FIN *************************************

        //***************************************  [B] INICIO *************************************
        //para el caso de identity usa el primer valor de la lista
        System.out.println("performMultiplicationWithNoInitialValue");
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }


        Optional<Integer> result1 = performMultiplicationWithNoInitialValue(Arrays.asList());
        System.out.println(result1.isPresent());
        //si se intenta hacer un get de un optional que no tiene información tirará NoSuchElementException
        //result1.get()     TODO Excepción!
        System.out.println();
        //***************************************  [B] FIN *************************************

        //***************************************  [C] INICIO *************************************
        System.out.println(getHighestGradeStudent().get());
        //***************************************  [C] FIN *************************************

        //***************************************  [D] INICIO *************************************
        System.out.println(combineStudentNames());
        //***************************************  [D] FIN *************************************

    }
}
