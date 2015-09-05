package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        if (month.equals("January"))
            System.out.println("January is 1 month");
        if (month.equals("February"))
            System.out.println("February is 2 month");
        if (month.equals("March"))
            System.out.println("March is 3 month");
        if (month.equals("April"))
            System.out.println("April is 4 month");
        if (month.equals("May"))
            System.out.println("May is 5 month");
        if (month.equals("June"))
            System.out.println("June is 6 month");
        if (month.equals("Jule"))
            System.out.println("Jule is 7 month");
        if (month.equals("August"))
            System.out.println("August is 8 month");
        if (month.equals("September"))
            System.out.println("September is 9 month");
        if (month.equals("October"))
            System.out.println("October is 10 month");
        if (month.equals("November"))
            System.out.println("November is 11 month");
        if (month.equals("December"))
            System.out.println("December is 12 month");

    }

}
