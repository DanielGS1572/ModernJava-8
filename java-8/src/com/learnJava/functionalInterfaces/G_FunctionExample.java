package com.learnJava.functionalInterfaces;

import java.util.function.Function;

public class G_FunctionExample {
    //El primer parametro es la entrada y el segunto es la salida

    static Function<String,String> upperCase =  (name) -> name.toUpperCase();

    static Function<String,String> addSomeString =  (name) -> name.concat("default");

    static Function<String,Integer> strLength =  (name) -> name.length();




    public static void main(String[] args) {

        System.out.println("Result is : " + upperCase.apply("java8"));

        //andThen recibo como parametro el resultado de upperCase (primer Function)
        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("java8"));

        //Compose method primero ejecutara lo que se encuentra dentro de compose() [addSomeString]
        System.out.println("Result of compose : " + upperCase.compose(addSomeString).apply("java8"));

        Function<String,String> abc = Function.identity();      //Para que sirve el identity si regresa el mismo valor?

        System.out.println(abc.apply("ABC"));


    }
}
