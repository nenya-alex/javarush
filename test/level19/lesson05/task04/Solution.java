package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "C:/1.txt";
//        String file2 = "C:/2.txt";
        reader.close();
        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        while (fr.ready())
        {
            int k = fr.read();
            if (k==46)
            {
                fw.write(33);
            }
            else
            {
                fw.write(k);
            }
        }
        fr.close();
        fw.close();
    }
}
