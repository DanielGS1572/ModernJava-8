package com.learnJava.lambda;

public class RunnableLambdaExample {
    /*
    Lambdas:
    - Tambien se llaman Anonymous Functions
    - No estan atadas a una clase
    - Se pueden usar como variables y pasar como parametros
    - Son la implementacion de Functionall Interfaces (SAM.- Single Abstract Method)
    */

    public static void main(String[] args) {

        /**
         * Prior Java 8
         */
        // Se se da click en Runnable ver que las interfaces por default son public + abstract
        // y que además esta anotado con @FunctionalInterface
        // Ver que se hace la implementación al vuelo, es lo mismo con lambdas, por eso solo siempre debe haber
        //  un metodo en la interfaz definida con @FunctionalInterface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        new Thread(runnable).start();

        //Java 8 - Lambda Syntax

        // ()->{}
        //assigning a lambda to a variable.

        Runnable runnableLambda = () -> {System.out.println("Inside Runnable 2");};
//esto es solo la demostración de curly braces con multiples lineas
        Runnable runnableLambdaMultiStatements = () -> {
                                        System.out.println("Inside Runnable 3");
                                        System.out.println("Inside Runnable 3");
        };
//todo duda... esto no lo interpretaría como return? esto sería correcto?
        Runnable runnableLambdaSimple = () -> System.out.println("Inside Runnable 3");


        new Thread(runnableLambda).start();
        new Thread(runnableLambdaMultiStatements).start();
        new Thread(runnableLambdaSimple).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 3");
            }
        }).start();

        //[anonymous classes] pasandole directamente la expression lambda, ver lineas anteriores para el caso de antes de java 8 usando anonymous classes

        new Thread(() -> System.out.println("Inside Runnable 4")).start();


    }
}
