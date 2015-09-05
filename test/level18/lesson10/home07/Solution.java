package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/
//хорошая задача
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
//        String file = "C:/a.txt";//для проверки
//        String s1 = "7";//для проверки
        String ss;
        String s2="";
        FileReader in = new FileReader(file);
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String[]> list1 = new ArrayList<String[]>();
        BufferedReader bufferedReader = new BufferedReader(in);
        while((ss=bufferedReader.readLine())!=null)
        {
            list.add(ss);
        }
        for (int i = 0; i < list.size(); i++)
        {
            list1.add(new String(list.get(i)).split(" "));
        }
        for (int i = 0; i < list1.size(); i++)
        {
            //if (s1.equals(list1.get(i)[0]))//для проверки
            if (args[0].equals(list1.get(i)[0]))
                for (int j = 0; j <list1.get(i).length ; j++)
                {
                   s2=s2+list1.get(i)[j]+" ";
                }
        }
        System.out.println(s2);
        bufferedReader.close();
        in.close();
    }
}
