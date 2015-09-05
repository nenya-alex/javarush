package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "C:/1.txt";
//        String file2 = "C:/2.txt";
        String s="";
        reader.close();
        Scanner scan = new Scanner(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        while (scan.hasNext())
        {
            list.add(scan.next());
        }
        scan.close();
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            try
            {
              int k = Integer.parseInt(list.get(i));
                //System.out.println(k);
              s=s+k+" ";
            }
            catch (Exception e)
            {}
        }
        //System.out.println(s);
        s=s.substring(0,s.length()-1);
        //System.out.println(s);
        writer.write(s);
        writer.close();
    }
}
