package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        int N1 = Integer.parseInt(n1);
        String n2 = reader.readLine();
        int N2 = Integer.parseInt(n2);
        String n3 = reader.readLine();
        int N3 = Integer.parseInt(n3);
        System.out.println(max3(N1, N2, N3));
        if (max3(N1, N2, N3) == N1)
        {
            System.out.println(max2(N2, N3));
            if (max2(N2, N3) == N2)
            {
                System.out.println(N3);
            }
            else
            {
                //System.out.println(N3);
                System.out.println(N2);
            }
        }
        if (max3(N1, N2, N3) == N2)
        {
            System.out.println(max2(N1, N3));
            if (max2(N1, N3) == N1)
            {
                System.out.println(N3);
            }
            else
            {
                //System.out.println(N3);
                System.out.println(N1);
            }
        }
        if (max3(N1, N2, N3) == N3)
        {
            System.out.println(max2(N1, N2));
            if (max2(N1, N2) == N2)
            {
                System.out.println(N1);
            }
            else
            {
                //System.out.println(N1);
                System.out.println(N2);
            }
        }
        //Напишите тут ваш код

    }
    public static int max2 (int a, int b)
    {
        int maxi;
        if (a>=b)
        {maxi = a;}
        else maxi = b;
        return maxi;
    }
    public static int max3 (int a, int b, int c)
    {
        int maxi;
        if (max2(a, b) >= c)
        {maxi = max2(a, b);}
        else maxi = c;
        return maxi;
    }
}
