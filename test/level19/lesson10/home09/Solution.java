package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();
    static List<String> list = new ArrayList<String>();
    static List<String> list3 = new ArrayList<String>();
    static List<String[]> list1 = new ArrayList<String[]>();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        list.add(result);
        list1.add(list.get(0).split("\n"));
        for (String[] s: list1)
        {
            for (int i = 0; i < s.length; i++)
            {

                if (i%2==0&&i!=0)
                {
                    System.out.println("JavaRush - курсы Java онлайн");
                    System.out.println(s[i]);
                }
                else
                {
                    System.out.println(s[i]);
                }

            }

        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
