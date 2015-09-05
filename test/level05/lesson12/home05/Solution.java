package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int S = 0;
       for (;true;)
       {
           String n = reader.readLine();
           if (n.equals("сумма") )
               break;
           else
           {
               int N = Integer.parseInt(n);
               S = S + N;
           }
       }
        System.out.println(S);//Напишите тут ваш код
    }
}
