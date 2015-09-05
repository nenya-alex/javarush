package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> C = new ArrayList<String>();
        List<String> F = new ArrayList<String>();
        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            C.add(city);
            String family = reader.readLine();
            F.add(family);

        }
        /*
        for (int i = 0; i < C.size(); i++)
        {
            System.out.println(C.get(i));
        }
        */
        //read home number
        //int houseNumber = Integer.parseInt(reader.readLine());
        String c = reader.readLine();

        for (int i = 0; i < C.size(); i++)
        {
            if (c.equals(C.get(i)))
            {
                System.out.println(F.get(i));
                break;
            }
        }

    }
}
