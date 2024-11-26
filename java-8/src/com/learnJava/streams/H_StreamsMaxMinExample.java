package com.learnJava.streams;

import java.util.*;

public class H_StreamsMaxMinExample {

/*
En lugar de regresar un int es preferible regresar un Optional y poder tomar la decisión de qué regresar si se pasa una lista vacia
Si se pasa una lista vacia regresaría el valor con el que inicia la secuencia (0) [identity value]
*/
    public static Optional<Integer> maxValue(List<Integer> integerList){
        return integerList.stream()
                //.reduce(0,(a,b)->(a>b) ? a : b);
        .reduce(Integer::max);
    }

    public static Optional<Integer> minValue(List<Integer> integerList){
        //ver que si se le pasa un identity value para el min siempre regresara 0 (si se inicializa con 0)
        return integerList.stream()
                .reduce((a,b)->(a<b) ? a : b);      //withouth identity value
                //.reduce(0,Integer::min);
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);
        Optional<Integer> maxValue = maxValue(integers);
        int max = maxValue.isPresent() ? maxValue.get():0;
        System.out.println("Max Value is : " + max);

        Optional<Integer> minValue =minValue(integers);
        int min = maxValue.isPresent() ? minValue.get():0;
        System.out.println("Min Value is : " + min);
    }
}
