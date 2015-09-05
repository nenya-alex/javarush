package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int Num1 = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int Num2 = Integer.parseInt(num2);
        for (int i = 0; i < Num1; i++)
        {
            for (int j = 0; j < Num2; j++)
            {
                System.out.print(8);
            }
            System.out.println();
        }
        //Напишите тут ваш код

    }
}
