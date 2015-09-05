package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> list = new ArrayList<String>();
    static List<String> list1 = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        //String file = "C:/a.txt";
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        while (reader1.ready())
        {
            list.add(reader1.readLine());
        }
        reader1.close();
        //System.out.println(list);

        for (String s: list)
        {
            StringBuilder sb = new StringBuilder(s);
            String s1 = String.valueOf(sb.reverse());
            System.out.println(s1);
            list1.add(s1);
        }
        //System.out.println(list1);
    }
}
