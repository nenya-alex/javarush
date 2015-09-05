package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
//хорошая задача
public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream in = new FileInputStream(args[0]);
        //FileInputStream in = new FileInputStream("c:/1.txt");// проверка решения

        int count=0;
        int k;
        int n = in.available();

        //System.out.println(n);

        while (in.available()>0)
        {
            k=in.read();
            if (k==32)
                count++;
        }
        //System.out.println(count);
        System.out.printf("%.2f", ((double)count/(double)n)*100);
        //System.out.println(((double)count/(double)n)*100);
        in.close();
    }
}
