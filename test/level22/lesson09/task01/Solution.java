package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static List<String> list = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "123.txt";
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready())
        {
            String str = fileReader.readLine();
            if (str!=null)
            {
                Scanner scanner = new Scanner(str);
                while (scanner.hasNext())
                {
                    list.add(scanner.next());
                }
            }
        }
        for (int i = 0; i <list.size()-1 ; i++)
        {
            for (int j = i+1; j < list.size(); )
            {
                StringBuilder sb = new StringBuilder(list.get(j));
                    String s1 = sb.reverse().toString();
                    if (s1.equals(list.get(i)))
                    {
                        Pair pair = new Pair();
                        pair.first = list.get(i);
                        pair.second = list.get(j);
                        result.add(pair);
                        list.remove(j);
                        break;
                    }
                    else
                    {
                     j++;
                    }
            }
        }
        fileReader.close();
//        System.out.println(list);
//        System.out.println(result.toString());

    }

    public static class Pair {
        String first;
        String second;



        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
