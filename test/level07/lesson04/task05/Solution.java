package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int A[] = new int [20];
        int B[] = new int [10];
        int C[] = new int [10];//Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < A.length; i++)
        {
            A[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < B.length; i++)
        {
            B[i] = A[i];
        }
        for (int i = 0; i < C.length; i++)
        {
          C[i] = A[A.length/2+i];
        }
        for (int i = 0; i < C.length; i++)
        {
            System.out.println(C[i]);
        }
    }
}
