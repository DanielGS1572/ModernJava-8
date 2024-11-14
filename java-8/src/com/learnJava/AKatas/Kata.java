package com.learnJava.AKatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1,2,3,4,4,5,5,6,7,7,8,9,9);
        List<Integer> uniqueList = new ArrayList<>();

        for(Integer i : integerList){
            if(!uniqueList.contains(i)){
                uniqueList.add(i);
            }
        }

        System.out.println(uniqueList);

        List<Integer> uniqueList1 = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueList1);
    }
}
