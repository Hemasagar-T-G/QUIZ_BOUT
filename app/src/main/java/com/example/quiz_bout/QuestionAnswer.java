package com.example.quiz_bout;

public class QuestionAnswer
{
    public static String question[]={
            "1) Who invented Java Programming?",
            "2) Which one of the following is not a Java feature?",
            "3) What is the extension of java code files?",
            "4) Which of the following is not an OOPS concept in Java?",
            "5) What is the extension of compiled java classes?"
    };

    public static String choices[][]={
            {"Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup"},
            {"Object-oriented","Use of pointers","Portable","Dynamic and Extensible"},
            {".js",".txt",".class",".java"},
            {"Polymorphism","Inheritance","Compilation","Encapsulation"},
            {".txt",".js",".class",".java"}
    };

    public static String correctAnswers[]={
            "James Gosling",
            "Use of pointers",
            ".java",
            "Compilation",
            ".class"
    };


}
