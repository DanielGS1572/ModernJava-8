package com.learnJava.methodreferences;

import java.util.function.Function;

public class A_FunctionMethodReferenceExample {

    /*
- El proposito de Method References es simplificar la implementación de functional interfaces
- Dado que ya existen la interfaces funcionales que ayudan a definir la firma para su implementación,
method reference ayudara a simplificarlo, su sintaxis es:
ClassName::instance-methodName [ClaseQueRecibe::Regresa]                        => este caso aplica para Function interface
ClassName::static-methodName
Instance::methodName            [ClaseQueRegresa::ResultadoDelMetodoQueRetorna] => este caso aplica para Consumer interface

Como las firmas estan muy acotadas de lo que recibe y lo que regresa, method reference usa este contexto
por ejemplo:
Lambda Expression
(s) -> s.toUpperCase();
Method Reference
String::toUpperCase;

Lo anterior no siempre aplica, por ejemplo no existe un method reference para Predicte
Predicate<Student> predicate = (s) -> s.getGradeLevel()>=3
    */


    /*
    IntelliJ puede converti un lambda en Method Reference
    */


    /**
     * Class::instancemethod
     */
    static Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();

    static Function<String,String> toUpperCaseMethodRefernce = String::toUpperCase;

    //
    static Function<String,Integer> toUpperCaseLambda2 = (s)->4;
    static Function<String,Integer> toUpperCaseLambda3 = String::length;

    public static void main(String[] args) {

        System.out.println(toUpperCaseLambda.apply("java8"));

        System.out.println(toUpperCaseMethodRefernce.apply("java8"));


    }
}
