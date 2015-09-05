package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
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
        for (String s: list)
        {
            int k=0;
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++)
            {
                if (Character.isDigit(ch[i]))
                {
                    k++;
                }
            }
            if (k!=0)
            {
                writer.write(s+" ");
            }
        }
        writer.close();
    }
}
