package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        byte[] mas = new byte[in.available()];
        in.read(mas);
        for (int i = mas.length-1; i>=0 ; i--)
        {
            out.write(mas[i]);
        }
        reader.close();
        in.close();
        out.close();

    }
}
