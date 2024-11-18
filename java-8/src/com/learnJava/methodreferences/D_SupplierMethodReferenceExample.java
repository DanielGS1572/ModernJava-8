package com.learnJava.methodreferences;

import com.learnJava.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class D_SupplierMethodReferenceExample {
//Constructor reference
    // ver que se le esta asignando a un suplier
    //esto no mandará llamar el constructor, se tiene que hacer get
static Supplier<Student> studentSupplier = Student::new;

//Ver que lo siguiente estaría mal
//    static Student studentSupplier = Student::new;

    public static void main(String[] args) {
//ver que imprime en consola el hello world
        //se tiene que usar .get para que imprima
        studentSupplier.get();
        System.out.println(studentSupplier);
        //System.out.println(studentSupplier.get());


        System.out.println();
        /*
        Para poder hacer uso de new y que el constructor recibe parametros

        */
        Function<String,Student> studentFunction = Student::new;
        System.out.println(studentFunction.apply("ABC"));

    }
}
