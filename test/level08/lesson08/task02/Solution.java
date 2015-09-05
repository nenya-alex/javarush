package com.javarush.test.level08.lesson08.task02;

import java.util.*;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    /*
    public static void main(String[] args)
    {
        System.out.println(removeAllNumbersMoreThan10(createSet()).toString());
    }
    */
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();
        //Напишите тут ваш код
        for (int i = 0; i < 20; i++)
        {
            set.add(i);
        }
        return (HashSet) set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Integer k = iterator.next();
            if (k > 10)
            {
                iterator.remove();
            }
        }
        return (HashSet) set;
    }
    /*
    public void toString(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(set.toString());
        }
    }
    */
}
