package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    /*
    public static void main(String[] args)
    {

        for (Map.Entry<String, Date> s: removeAllSummerPeople(createMap()).entrySet())
        {
            System.out.println(s.getKey()+"-"+s.getValue());
        }


    }
    */
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне0", new Date("JUNE 1 1980"));
        map.put("Сталлоне1", new Date("JUNE 2 1981"));
        map.put("Сталлоне2", new Date("MAY 1 1980"));
        map.put("Сталлоне3", new Date("MARCH 1 1980"));
        map.put("Сталлоне4", new Date("JUNE 1 1980"));
        map.put("Сталлоне5", new Date("SEPTEMBER 1 1980"));
        map.put("Сталлоне6", new Date("DECEMBER 1 1980"));
        map.put("Сталлоне7", new Date("JUNE 6 1980"));
        map.put("Сталлоне8", new Date("JUNE 7 1980"));
        map.put("Сталлоне9", new Date("AUGUST 8 1980"));

        //Напишите тут ваш код
        return map;
    }
    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            /*
            if (iterator.next().getValue().getMonth()>4 && iterator.next().getValue().getMonth()<8)
            {
                iterator.remove();
            }
            */

            if (value.getMonth()>4 && value.getMonth()<8)
            {
                iterator.remove();
            }

        }

    }
    /*
    public static HashMap<String, Date> removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if (value.getMonth()>4 && value.getMonth()<8)
            {
                iterator.remove();
            }

        }
        return map;
    }
      */

}
