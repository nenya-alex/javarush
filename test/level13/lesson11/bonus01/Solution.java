package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import javax.sound.midi.Sequence;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //InputStream in = new FileInputStream(s);
        //OutputStream out = new PrintStream(System.out);
        File file = new File(s);

        BufferedReader r = new BufferedReader(new FileReader(file));
        String line;

        List<String> list = new ArrayList<String>();
        while ((line = r.readLine()) != null) {
            list.add(line);
        }
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            if (Integer.parseInt(list.get(i))%2 == 0)
            {
                list1.add(Integer.parseInt(list.get(i)));
            }
        }
        int A[] = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++)
        {
            A[i] = list1.get(i);
        }
        Arrays.sort(A);
        /*
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("--------------------");
        */
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }
        /*
        while (in.available()>0)
        {
            out.write(in.read());
        }
        */
       // in.close();
       // out.close();
    }
}
