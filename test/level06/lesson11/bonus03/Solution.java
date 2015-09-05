package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int A[] = new int [5];
        for (int i = 0; i < A.length; i++)
        {
            A[i]= Integer.parseInt(reader.readLine());
        }
        for(int i = A.length-1 ; i > 0 ; i--)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if( A[j] > A[j+1] )
                {
                int tmp = A[j];
                A[j] = A[j+1];
                A[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }
        //Напишите тут ваш код
    }
}
