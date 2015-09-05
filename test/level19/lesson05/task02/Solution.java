package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "C:/1.txt";
        reader.close();
        String s;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String[]> list1 = new ArrayList<String[]>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
         while ((s=br.readLine())!=null)
        {
            list.add(s);
        }
        br.close();
        fr.close();
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            list2.add(list.get(i).replaceAll("[.,]", ""));
        }
        //System.out.println(list2);
        for (int i = 0; i < list2.size(); i++)
        {
            list1.add(list2.get(i).split(" "));
        }

        for (int i = 0; i < list1.size(); i++)
        {
            for (int j = 0; j < list1.get(i).length; j++)
            {
                list3.add(list1.get(i)[j]);
            }
        }
        //System.out.println(list3);
        System.out.println(Collections.frequency(list3, "world"));
    }
}
