package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/
//так работает, но не принимается
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
//        String file = reader.readLine();
//        FileInputStream stream = new FileInputStream(file);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//
//        //FileInputStream stream = new FileInputStream("C:/a.txt");
//
//        byte[] mas = new byte[stream.available()];
//        stream.read(mas);
//        Arrays.sort(mas);
//        for (int i = 0; i < mas.length; i++)
//        {
//            list.add((int) mas[i]);
//        }
//        for (int i = 0; i < list.size()-1; i++)
//        {
//                while (list.get(i)==list.get(i+1))
//                {
//                    list.remove(i+1);
//                }
//        }
//        for (int i = 0; i < list.size(); i++)
//        {
//            System.out.print(list.get(i)+" ");
//        }
//        reader.close();
//        stream.close();
//    }
//}
//принята в таком виде, что сомнительно в отношение простоты решения
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream stream = new FileInputStream(file);
        Set<Integer> set = new TreeSet<Integer>();

        //FileInputStream stream = new FileInputStream("C:/a.txt");
            while (stream.available()>0)
            {
                set.add(stream.read());
            }

        for (Integer s: set)
        {
            System.out.print(s+" ");
        }
        reader.close();
        stream.close();
    }
}