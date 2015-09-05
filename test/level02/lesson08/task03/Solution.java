package com.javarush.test.level02.lesson08.task03;

/* Минимум трех чисел
Написать функцию, которая вычисляет минимум из трёх чисел.
Подсказка:
Нужно написать тело существующей функции min и исправить возвращаемое значение.
*/
public class Solution
{
    public static int min(int a, int b, int c)
    {
        int min3;//Напишите тут ваш код
        if (min2(a,b)<=c)
        {
            min3=min2(a,b);
        }
        else
        {
            min3 = c;
        }
        return min3;
    }
    public static int min2(int a, int b)
    {
        int min2;//Напишите тут ваш код
        if (a<=b)
        {
            min2=a;
        }
        else
        {
            min2 = b;
        }
        return min2;
    }
    public static void main(String[] args) throws Exception
    {
        if (min(5, 8, 6) != 5) {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        System.out.println(min(5, 8, 6));
        if (min(5, 6, 8) != 5) {
            System.out.println("2) Неправильно для a"); //вывод=5
        }
        System.out.println(min(5, 6, 8));
        if (min(-3, -5, -2) != -5) {
            System.out.println("3) Неправильно для отрицательных чисел"); //вывод=-5
        }
        System.out.println(min(-3, -5, -2));
        if (min(10, 5, 20) != 5) {
            System.out.println("4) Неправильно для b"); //вывод=5
        }
        System.out.println(min(10, 5, 20));
        if (min(20, 5, 10) != 5) {
            System.out.println("5) Неправильно для b"); //вывод=5
        }
        System.out.println(min(20, 5, 10));
        if (min(5, 5, 5) != 5) {
            System.out.println("6) Неправильно для всех равных чисел"); //вывод=5
        }
        System.out.println(min(5, 5, 5));
        if (min(8, 7, 5) != 5) {
            System.out.println("7) Неправильно для c"); //вывод=5
        }
        System.out.println(min(8, 7, 5));
        if (min(7, 8, 5) != 5) {
            System.out.println("8) Неправильно для c"); //вывод=5
        }
        System.out.println(min(7, 8, 5));
        if (min(5, 5, 6) != 5) {
            System.out.println("9) Неправильно для пары равных чисел"); //вывод=5
        }
        System.out.println(min(5, 5, 6));
    }

}