package com.javarush.test.level09.lesson02.task03;

/* Метод должен вернуть номер строки кода, из которого вызвали этот метод
Написать пять методов, которые вызывают друг друга. Метод должен вернуть номер строки кода, из которого вызвали этот метод. Воспользуйся функцией: element.getLineNumber().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a = method1();
        System.out.println(a);
    }

    public static int method1()
    {
        int a = method2();
        System.out.println(a);
        StackTraceElement[] n = Thread.currentThread().getStackTrace();
        return  /*add your code here*/ n[2].getLineNumber();
    }

    public static int method2()
    {
        int a = method3();
        System.out.println(a);
        StackTraceElement[] n = Thread.currentThread().getStackTrace();
        return  /*add your code here*/ n[2].getLineNumber();
    }

    public static int method3()
    {
        int a = method4();
        System.out.println(a);
        StackTraceElement[] n = Thread.currentThread().getStackTrace();
        return  /*add your code here*/ n[2].getLineNumber();
    }

    public static int method4()
    {
        int a = method5();
        System.out.println(a);
        StackTraceElement[] n = Thread.currentThread().getStackTrace();
        return  /*add your code here*/ n[2].getLineNumber();
    }

    public static int method5()
    {
        StackTraceElement[] n = Thread.currentThread().getStackTrace();
        return  /*add your code here*/ n[2].getLineNumber();
    }
}
