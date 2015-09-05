package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int []> arrayList = new ArrayList<int[]>();
        int A1[] = {1,2,3,4,5};
        int A2[] = {0,-5};
        int A3[] = {-1,-2,-3,-4};
        int A4[] = {11,21,31,41,51,61,71};
        int A5[] = {};
        arrayList.add(A1);
        arrayList.add(A2);
        arrayList.add(A3);
        arrayList.add(A4);
        arrayList.add(A5);
        //Написать тут ваш код
        return arrayList;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
