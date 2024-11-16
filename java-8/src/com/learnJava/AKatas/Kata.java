package com.learnJava.AKatas;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    static Predicate<Integer> mod2 = i -> i%2 == 0;
    static Predicate<Integer> mod5 = i -> i%5 == 0;
    public static void main(String[] args){
        System.out.println(mod2.and(mod5).test(4));
        System.out.println(mod5.negate().and(mod2).test(4));
    }

}
