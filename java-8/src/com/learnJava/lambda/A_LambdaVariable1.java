package com.learnJava.lambda;

import java.util.function.Consumer;

public class A_LambdaVariable1 {

/*
- Dos restricciones de variables:
1) No es posible usar variables locales como el nombre del parametro de lambda
2) No es posible re-asignar el valor de una variable definida dentro de una expresión lambda (no hay restricciones para instance variables)

* Que es effectively final?
Antes de java 7 al implementar una clase anonima se tenía que definir las variables como final
las lambdas al ser como una clase anonima ya no es necesario poner final, es por eso el nombre de
effectively final, porque por default trata a la variable definida como final

* y porque se hace esto de manejarse como final?
Effectively final ayuda a multithread ya que no se puede modificar su valor
Aparte de que promueve el tipo de programación funcional (vs imperativo)
*/
    public static void main(String[] args) {

        int i=0; //Repeated varibale name not allowed
        //Consumer<Integer> c1 = (i) -> {
        Consumer<Integer> c1 = (a) -> {
            //int i=0;
            System.out.println(i);
        };

    }
}
