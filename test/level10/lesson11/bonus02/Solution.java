package com.javarush.test.level10.lesson11.bonus02;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка – конец ввода данных. Числа могу повторяться. Строки всегда уникальны. Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мама
2 Рама
1 Мыла
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<String, Integer>();
       for (;true;)
       {
           String s = reader.readLine();
           if (s.isEmpty())
           {
               //map.put(name,id);
               break;
           }
           int id = Integer.parseInt(s);
           String name = reader.readLine();


           map.put(name,id);
       }
        /*
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
*/
        for (Map.Entry<String, Integer> s: map.entrySet())
        {
            System.out.println(s.getValue()+" "+s.getKey());
        }


        //System.out.println("Id=" + id + " Name=" + name);
    }
}
