package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream stream = new FileInputStream(fileName);
        long min = stream.read();
        while (stream.available()>0)
        {
            long str = stream.read();
            if (str<min)
            {
                min=str;
            }
        }
        System.out.println(min);
        reader.close();
        stream.close();
    }
}
