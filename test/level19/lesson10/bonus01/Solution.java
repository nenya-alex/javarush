package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(r.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(r.readLine()));
        r.close();

        ArrayList<String> file1 = new ArrayList<>();
        while (reader1.ready())
            file1.add(reader1.readLine());

        ArrayList<String> file2 = new ArrayList<>();
        while (reader2.ready())
            file2.add(reader2.readLine());

        int i = 0, j = 0;

        while (i < file1.size() && j < file2.size())
        {
            if (file1.get(i).equals(file2.get(j)))
            {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                //System.out.println("SAME " + file1.get(i));
                i++;
                j++;
            } else if (file1.get(i).equals(file2.get(j + 1)))
            {
                lines.add(new LineItem(Type.ADDED, file2.get(j)));
                //System.out.println("ADDED " + file2.get(j));
                j++;
            } else if (file1.get(i + 1).equals(file2.get(j)))
            {
                lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                //System.out.println("REMOVED " + file1.get(i));
                i++;
            }
        }
        if (i < file1.size())
        {
            lines.add(new LineItem(Type.REMOVED, file1.get(file1.size() - 1)));
            //System.out.println("REMOVED " + file1.get(file1.size() - 1));
        }
        if (j < file2.size())
        {
            lines.add(new LineItem(Type.ADDED, file2.get(file2.size() - 1)));
            //System.out.println("ADDED " + file2.get(file2.size() - 1));
        }
    }

    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
