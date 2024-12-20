package com.learnJava.methodreferences;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class C_RefactorMethodReferenceExample {

    static Predicate<Student> predicateUsingLambda = (s) -> s.getGradeLevel()>=3;
//Ver que se esta haciendo llamado del tipo Class::staticMethod
    static Predicate<Student> predicateUsingMetRef = C_RefactorMethodReferenceExample::greaterThan;


    static BiPredicate<Student,Integer> predicateUsingMethodReference = C_RefactorMethodReferenceExample::greaterThan;

    static public  boolean greaterThan(Student student){

        return student.getGradeLevel() >3;
    }

   static public  boolean greaterThan(Student student,Integer grade){

        return student.getGradeLevel() >grade;
    }

    public static void main(String[] args) {

        System.out.println(predicateUsingLambda.test(StudentDataBase.studentSupplier.get()));
        System.out.println(predicateUsingMetRef.test(StudentDataBase.studentSupplier.get()));
        System.out.println(predicateUsingMethodReference.test(StudentDataBase.studentSupplier.get(),3));

    }
}
