package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        int Num1 = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int Num2 = Integer.parseInt(num2);
        //Напишите тут ваш код
        int min;
        if (Num1<=Num2)
        {
            min = Num1;
        }
        else min = Num2;
        System.out.println(min);
        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}