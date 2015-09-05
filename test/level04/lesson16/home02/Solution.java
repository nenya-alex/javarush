package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String n1 = reader.readLine();
         int N1 = Integer.parseInt(n1);
        String n2 = reader.readLine();
        int N2 = Integer.parseInt(n2);
        String n3 = reader.readLine();
        int N3 = Integer.parseInt(n3);
        if (N1>N2)
        {
            if (N2>N3)
            System.out.println(N2);
        }
        else
        {
            if (N2<N3)
                System.out.println(N2);
        }
        if (N2>N1)
        {
            if (N1>N3)
                System.out.println(N1);
        }
        else
        {
            if (N1<N3)
                System.out.println(N1);
        }
        //Напишите тут ваш код
        if (N1>N3)
        {
            if (N3>N2)
                System.out.println(N3);
        }
        else
        {
            if (N3<N2)
                System.out.println(N3);
        }
    }
}
