package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class A_ConsumerExample {
/*
En esta clase el metodo main esta hasta abajo

Se usan dos clases para los datos
- Student
- StudentDatabase.- Regresa una lista de Student

Primary interfaces      -       Extensions

Consumer    => Accept some input and do some operation over that input (sin retornar nada -puede no llevar parentesis-)
-       BiConsumer

Predicate   => Acepta un tipo de dato y regresa un booleano
-       BiPredicate
Function    => Acepta un parametro de un tipo y regresa otro tipo (puede ser el mismo tipo o diferente)
-       BiFunction, UnaryOperator, BinaryOperator
Supplier
*/
    static Consumer<Student>  c1= p -> System.out.println(p);

    static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());


    public static void printName(){

        List<Student> personList = StudentDataBase.getAllStudents();

        personList.forEach(c1);         //Ver que aqui se da la programación funcional
        // Dar click en forEach para ver que recibe como parametro
        // Ver que recibe un consumer y de esta manera se puede ejecutar diferentes implementaciones
        System.out.println();
        System.out.println();


    }

    public static void printNameAndActivities(){
        System.out.println("printNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c2.andThen(c3));     //Consumer Chaining.- Primero ejecutará c2 y luego c3
        //ver que andThen pertenece a la clase consumer que solo recibirá un tipo de dato que sea/herede del objeto que esta siendo llamado el metodo .andThen
        //en este caso debe ser de tipo Student
        System.out.println();
        System.out.println();
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach((s) -> {
            if( s.getGradeLevel()>=3 && s.getGpa()>3.9){
                c2.andThen(c3).accept(s);           //ver que se tiene que usar accept para una implementación al vuelo
            }
        });
        System.out.println();
        System.out.println();

    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        //Ver que accept es para que se ejecute la implementación de la interfaz que
        // acepta un valor que solo será consumido es decir, no regresará nada
        c1.accept("java8");

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();





    }
}
