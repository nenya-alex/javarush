package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int A[] = new int [10];//Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < A.length; i++)
        {
            A[i] = Integer.parseInt(reader.readLine());
        }
        /*
        int B[] = new int [10];
        for (int i = 0; i < B.length; i++)
        {
            B[i] = A[A.length - 1 - i];
            System.out.println(B[i]);
        }
*/
        for (int i = 0; i < A.length/2; i++)
        {
            int tmp = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = tmp;
        }
        for (int i = 0; i < A.length; i++)
        {

            System.out.println(A[i]);
        }
        /*
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[A.length-i-1]);
        }
        */
    }
}
