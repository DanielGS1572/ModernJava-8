package com.learnJava.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class L_BinaryOperatorExample {

   static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {
/*
BinaryOperator extiende de BiFunction, pero ver
que para BiFunction los genericos se definen con diferentes letras <T, U, R>
y para el caso de BinaryOperator todas tienen T... lo que representa que
recibe dos parametros del mismo tipo y el tipo de retorno es el mismo
 */
        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

        System.out.println(binaryOperator.apply(3,4));


        //de los metodos estaticos, solo acepta Comparator
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Result is: " + maxBy.apply(5, 6));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Result is: " + minBy.apply(5, 6));

    }
}
