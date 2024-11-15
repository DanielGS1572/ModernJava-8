package com.learnJava.functionalInterfaces;

import java.util.function.UnaryOperator;

public class K_UnaryOperatorExample {
//UnaryOperator extiende de Function
    //Característica de UnaryOperator: Lo que recibe es lo mismo que regresa
    static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");



    public static void main(String[] args) {

        System.out.println(unaryOperator.apply("java8"));


    }
}
