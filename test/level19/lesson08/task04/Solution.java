package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] mas = result.split(" ");
        int n=0;
        char c = mas[1].charAt(0);
        if (c==43)
        {
            n = Integer.parseInt(mas[0])+Integer.parseInt(mas[2]);
        }
        else
        if (c==45)
        {
            n = Integer.parseInt(mas[0])-Integer.parseInt(mas[2]);
        }
        else
        if (c==42)
        {
            n = Integer.parseInt(mas[0])*Integer.parseInt(mas[2]);
        }
        System.out.println(mas[0]+" "+mas[1]+" "+mas[2]+" "+mas[3]+" "+n);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

