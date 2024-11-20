package com.learnJava.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class A1_CollectionsvsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        Stream<String> namesStream = names.stream();

        namesStream.forEach(System.out::println);
        //[A]
        //namesStream.forEach(System.out::println);       //stream has already been operated upon or closed

    }
}
