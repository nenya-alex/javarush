package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/
//  не работет, не принята
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void find (String s, String ss)
    {
        String s2;
        if (ss.equals("obj"))
        {
            int m=s.indexOf("=");
            int l=s.indexOf("&");
            if (l>0)
            {
                s2=s.substring(m+1,l);
                try
                {
                    Double d = Double.parseDouble(s2);
                    alert(d);
                }
                catch (Exception e)
                {
                    alert(s2);
                }
            }
            else
            {
                s2=s.substring(m+1);
                try
                {
                    Double d = Double.parseDouble(s2);
                    alert(d);
                }
                catch (Exception e)
                {
                    alert(s2);
                }
            }

        }
    }
    public static void main(String[] args) throws IOException
    {
        //add your code here
        ArrayList<String > list = new ArrayList<String>();
        ArrayList<String > list1 = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //int k = s.indexOf("?");
        s=s.substring(s.indexOf("?") + 1);
        //System.out.println(s);
        int k, n, m, l;
        String s2;
        do
        {
            k = s.indexOf("&");
            if (k>0)
            {
                String s1=s.substring(0,k);
                list.add(s1);
                n = s1.indexOf("=");
                if (n>0)
                {
                    s1=s1.substring(0,n);
                }
                list1.add(s1);
                System.out.print(s1+" ");



                s=s.substring(k+1);

            }
            else
            {
                list.add(s);
                n = s.indexOf("=");
                if (n>0)
                {
                    s=s.substring(0,n);
                }
                System.out.println(s);
                list1.add(s);



            }
            //System.out.println(s);
        }
        while (k>0);
        for (int i = 0; i < list.size(); i++)
        {
            find(list.get(i), list1.get(i));
        }

    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
