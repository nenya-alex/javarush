package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        String n4 = reader.readLine();
        int N4 = Integer.parseInt(n4);
        //Напишите тут ваш код
        int max;

        if (max2(N1, N2) >= max2(N3, N4))
        {
            max = max2(N1, N2);
        }
        else max = max2(N3, N4);
        System.out.println(max);
    }
    public static int max2 (int a, int b)
    {
        int maxi;
        if (a>=b)
        {maxi = a;}
        else maxi = b;
        return maxi;
    }
}
