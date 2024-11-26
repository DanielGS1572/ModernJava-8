package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.Predicate;

public class G_StreamsFilterMapReduceExample {

    static Predicate<Student> genderPredicte =(student -> {
        return student.getGender().equals("male");
    });

    static Predicate<Student> gradeLevel =(student -> {
        return student.getGradeLevel()==2.0;
    });
/*
        Lo que se obtendrá es el numero total de notebooks de la colección
*/
    private static int noOfNoteBooks(){

        int totalNoOfnoteBooks = StudentDataBase.getAllStudents().stream()
                //.filter(genderPredicte)
               // .filter(gradeLevel)
              /*  .peek(s->{
                    System.out.println("s : "+ s);
                })*/
                .map((Student::getNoteBooks))
               /* .peek(s1->{
                    System.out.println("s1 : "+ s1);
                })*/
               // .reduce(0,(a,b)->a+b); //summing the notebooks.       //Todo importante... Integer no tiene la opción de multiplicación por lo que la alternativa es desglozar la operación
                .reduce(0,Integer::sum); //summing the notebooks.
        return  totalNoOfnoteBooks;

    }
    public static void main(String[] args) {

        System.out.println("Total No of NoteBooks are : " + noOfNoteBooks());
    }
}