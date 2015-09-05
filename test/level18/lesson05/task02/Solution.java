package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream stream = new FileInputStream(file);
        int count=0;

        //FileInputStream stream = new FileInputStream("C:/a.txt");
        byte[] mas = new byte[stream.available()];
        stream.read(mas);
        //System.out.println(Arrays.toString(mas));
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i]==44)
                count++;
        }
        System.out.println(count);
        reader.close();
        stream.close();
    }
}
