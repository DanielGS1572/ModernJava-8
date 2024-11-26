package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class I_StreamsLimitSkipExample {

    //Las dos funciones de Limit y skip ayudan a crear sub-streams
    //limit del primer valor al limite definido
    //skip brinca los primeros valores hasta completar el stream

    public static Optional<Integer> limit(List<Integer> integers){
        return  integers.stream()
                .limit(2)
                .reduce((a,b)-> a+b);

    }

    public static Optional<Integer> skip(List<Integer> integers){
        return  integers.stream()
                .skip(3)
                .reduce((a,b)-> a+b);
    }
    

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        Optional<Integer> limitResult = limit(integers);
        int result = limitResult.isPresent() ? limitResult.get() : 0;
        System.out.println("The limit result is : " + result);

        Optional<Integer> skipResult = skip(integers);
        int result1 = skipResult.isPresent() ? skipResult.get() : 0;
        System.out.println("The skip result is : " + result1);

    }
}
