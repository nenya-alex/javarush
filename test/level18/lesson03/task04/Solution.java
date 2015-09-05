package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream stream = new FileInputStream(file);


        //FileInputStream stream = new FileInputStream("C:/a.txt");
        byte[] mas = new byte[stream.available()];
        byte[] mas1 = new byte[stream.available()];
        int[] mas2 = new int[stream.available()];
        stream.read(mas);
        //System.out.println(Arrays.toString(mas));
        //System.out.println(mas.length);
        for (int i = 0; i < mas.length; i++)
        {
            int count=1;
            for (int j = i+1; j < mas.length; j++)
            {
                if (mas[i]>=0)
                {
                    if (mas[i]==mas[j])
                    {
                        mas[j]=-1;
                        count++;
                    }
                }
            }
            mas1[i]=mas[i];
            mas2[i]=count;
        }
        int min=mas2[0];
        for (int i = 1; i < mas2.length; i++)
        {
            if (mas2[i]<min)
                min=mas2[i];
        }
        for (int i = 0; i < mas.length; i++)
        {
            if (mas2[i]==min && mas[i]>=0)
                System.out.print(mas[i]+" ");
        }
//        System.out.println(Arrays.toString(mas));
//        System.out.println(mas.length);
        //System.out.println(Arrays.toString(mas1));
//        System.out.println(Arrays.toString(mas2));
//        System.out.println(mas2.length);
        reader.close();
        stream.close();
    }
}
