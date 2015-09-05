package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    static List<String> list = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("a");
//        words.add("b");
//        words.add("c");
    }

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
        int i = 0;
        for (String s: list)
        {
            for (int j = 0; j < words.size(); j++)
            {
                if (s.contains(words.get(j)))
                {
                    i++;
                }
            }
            if (i==2)
            {
                System.out.println(s);
            }
            i=0;
        }
    }
}
