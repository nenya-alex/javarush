package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> A[] = new ArrayList[3];
        list.add("dd");
        list.add("ddkk");
        list.add("ddlkju");
        list.add("rdfydd");
        list1.add("dd1");
        list1.add("ddkk1");
        list1.add("ddlkju1");
        list1.add("rdfydd1");
        list2.add("dd2");
        list2.add("ddkk2");
        list2.add("ddlkju2");
        list2.add("rdfydd2");

            A[0] = list;
        A[1] = list1;
        A[2] = list2;
        return A;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}