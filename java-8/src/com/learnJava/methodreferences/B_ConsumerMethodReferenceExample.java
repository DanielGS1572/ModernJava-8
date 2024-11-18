package com.learnJava.methodreferences;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.Consumer;

public class B_ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     System.err es de la clase System que a su vez tiene una propiedad estatica del tipo PrintStream
     Es por eso que se maneja como Class::instancemethod
     */
    static Consumer<Student>  c1= System.err::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
        StudentDataBase.getAllStudents().forEach(c3);
    }

}
