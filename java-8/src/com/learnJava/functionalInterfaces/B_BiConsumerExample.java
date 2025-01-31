package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class B_BiConsumerExample {
    /*
    - BiConsumer acepta dos inputs (para revisar simplemente dar click en la interfaz
    y ver que tiene dos genericos distintos
    */

    public static void nameAndActivities(){
//misma implementación que el Caso de consumer, pero ver que aqui se tiene mas control al poder concatenar con otro string (ambos parametro)
        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

        Consumer<String> stringConsumer = (name) -> System.out.println("name is  :" + name);

        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println("\nBiConsummer1\n");
        students.forEach((s) -> stringConsumer.accept(s.getName()));

        System.out.println("\nBiConsummer2\n");
//Ver que el forEach acepta un Consumer y no un BiConsumer
//[duda] porque se tiene que poner el accept si ya lo esta haciendo en el lambda -- porque tiene que iterar sobre cada uno de los elementos de la lista
        students.forEach((s) -> studentBiConsumer.accept(s.getName(),s.getActivities()));   //Ver que como se esta haciendo la implementación del lambda ( s -> ) se tiene que usar accept
    }

    public static void main(String[] args) {

//ver que se definen los tipos dentro del operador diamante
        BiConsumer<String, String> biConsumer = (a,b) -> {
            //dado que Consumer no regresa información por eso nada más se usa un sout
            System.out.println(" a : "  +  a + " b : " + b );
        };
        biConsumer.accept("java7" , "java8");

        /*
        La siguiente instruccción esta mal porque no acepta primitivos, tienen que ser objetos
        static BiConsumer<int,int> suma = (n1,n2)-> System.out.println(n1+n2);                  //Incorrecto
        static BiConsumer<Integer,Integer> suma = (n1,n2)-> System.out.println(n1+n2);          //Correcto
        */

        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("Multiplication : " + (a * b));
        };


        BiConsumer<Integer, Integer> addition = (a,b) -> {
            System.out.println("Addition : " + (a + b));
        };

        BiConsumer<Integer, Integer> division = (a,b) -> {
            System.out.println("Division : "  + (a / b));
        };


        multiply.andThen(addition).andThen(division).accept(10,5); //TODO importante... ver que el accept es como pasarle los dos parametros al biFunction por cada andThen (junto con el primer multiply)


        nameAndActivities();

    }
}
