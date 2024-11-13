package com.learnJava.functionalInterfaces;

import java.util.function.Predicate;

public class C_PredicateExample {
//El predicate recibe un valor y regresa un boolean
    //una pregunta que puede surgir es porque usar un Predicate si es algo muy directo
    // el tema es la reusabilidad, ya que es programación funcional
    static Predicate<Integer> p = (i) -> {return  i%2 ==0;};
// ejemplo de no usar return ni curly braces
    static Predicate<Integer> p1 = (i) -> i%2 ==0;

    static Predicate<Integer> p2 = (i) -> i%5 ==0;


    public static void predicateAnd(){
//arrojará true como resultado ya que 10 es divisible por 2 y 5
        //ver que regresa un booleano
        //ver que con test se le pasa el valor al Predicate
        System.out.println("Result in predicateAnd10 : " + p1.and(p2).test(10));
        System.out.println("Result in predicateAnd2 : " + p1.and(p2).test(2));
    }

    public static void predicateOr(){

        System.out.println("Result in predicateOr10 : " + p1.or(p2).test(10));
        System.out.println("Result in predicateOr9 : " + p1.or(p2).test(4));
    }

    public static void predicateNegate(){
//ver que negate se puede concatenar con and y or
        System.out.println("Result in predicateNegate : " + p1.and(p2).negate().test(4)); //equivalent to reversing the result
    }


    public static void main(String[] args) {

        System.out.println("Result is p : " + p.test(2));

        System.out.println("Result is p1 : " + p1.test(3));

        predicateAnd();

        predicateOr();

        predicateNegate();

    }


}
