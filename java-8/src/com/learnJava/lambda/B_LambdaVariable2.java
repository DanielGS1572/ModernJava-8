package com.learnJava.lambda;

import java.util.function.Consumer;

public class B_LambdaVariable2 {

    static int value =4;

    public static void main(String[] args) {

//no esta permitido cambiar una variable dentro del metodo donde se define el lambda
        // int value =4; //effectively final
        Consumer<Integer> c1 = (a) -> {
            value=6;
            //  System.out.println(i+value);
        };
        //value =2;

        c1.accept(2);
    }
}
