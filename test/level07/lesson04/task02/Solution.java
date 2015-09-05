package com.javarush.test.level07.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String A[] = new String[10];//Напишите тут ваш код
        String B[] = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++)
        {
            A[i] = reader.readLine();
        }
        for (int i = 0; i < B.length; i++)
        {
            B[i] = A[A.length-1-i];
        }
        for (int i = 0; i < B.length; i++)
        {
            System.out.println(B[i]);
        }
    }
}