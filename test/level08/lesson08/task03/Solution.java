package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++)
        {
            map.put("A"+i, "B"+i);
        }
        /*
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        map.put("A", "B");
        */
        //Напишите тут ваш код
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
       int k=0;
        //Напишите тут ваш код
        for (Map.Entry<String, String> s: map.entrySet())
        {
            if (s.getValue().equals(name))
            {
                k=k+1;
            }
        }

       return k;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int k=0;
        //Напишите тут ваш код
        for (Map.Entry<String, String> s: map.entrySet())
        {
            if (s.getKey().equals(familiya))
            {
                k=k+1;
            }
        }

        return k;//Напишите тут ваш код

    }
}
