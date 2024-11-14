package com.learnJava.imperativevsdeclarative;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {

    public static void main(String[] args) {


        // Imperative Style - how style of programming

        int sum=0;
        for(int i=0;i<=100;i++){
                sum+=i;
        }
        System.out.println("Sum is : "+sum);


        // Declarative

        // Una de las ventajas de los streams es que es Thread Safe en un ambiente multithread, si se quisiera hacer en paralelo de forma imperativa (ejemplo anterior)
        // se tendrían que definir el metodo con synchronized
        int sum1= IntStream.rangeClosed(0,100)   //rangeClosed se refiere a que si tomará el ultimo valor del rango
                //.parallel()
                //.map(Integer::new)
                .sum();

        System.out.println("sum1 : " + sum1);

    }

}
