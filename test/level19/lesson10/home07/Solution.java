package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        //String[] args = {"C:/a.txt", "C:/b.txt"};
        Scanner scan = new Scanner(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        while (scan.hasNext())
        {
            list.add(scan.next());
        }
        scan.close();
        //System.out.println(list);
        String str="";
        for (String s: list)
        {
            if (s.length()>6)
            {
                str=str+s+",";

            }
        }

        str=str.substring(0, str.length()-1);
        //System.out.println(str);
        writer.write(str);
        writer.close();
    }
}
