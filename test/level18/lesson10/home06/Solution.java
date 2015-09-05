package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //String file = "C:/a.txt";//для проверки
        //FileInputStream in = new FileInputStream(file);//для проверки
        FileInputStream in = new FileInputStream(args[0]);//для проверки отключить
        byte[] mas = new byte[in.available()];
        ArrayList<Byte> list1 = new ArrayList<Byte>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        in.read(mas);
        //System.out.println(Arrays.toString(mas));//для проверки
        for (int i = 0; i < mas.length-1; i++)
        {
            int count = 1;
            if (mas[i]!=-1)
            {
                for (int j = i+1; j < mas.length; j++)
                {
                        if (mas[i]==mas[j])
                        {
                            count++;
                            mas[j]=-1;
                        }
                }
                list1.add(mas[i]);
                list2.add(count);
            }
        }
        byte[] mas1 = new byte[list1.size()];
        int[] mas2 = new int[list2.size()];
        for (int i = 0; i < list1.size(); i++)
        {
            mas1[i]=list1.get(i);
            mas2[i]=list2.get(i);
        }
//        System.out.println(list1);//для проверки
//        System.out.println(list2);//для проверки
//        System.out.println(Arrays.toString(mas1));//для проверки
//        System.out.println(Arrays.toString(mas2));//для проверки
        for (int i = 0; i < mas1.length-1; i++)
        {
            for (int j = i+1; j < mas1.length; j++)
            {
                if (mas1[i]>mas1[j])
                {
                    byte tmp = mas1[i];
                    mas1[i]=mas1[j];
                    mas1[j]=tmp;
                    int tmp1 = mas2[i];
                    mas2[i]=mas2[j];
                    mas2[j]=tmp1;
                }
            }
        }
        String s= new String(mas1);
//        System.out.println(s);//для проверки
        for (int i = 0; i < mas2.length; i++)
        {
            System.out.println(s.charAt(i)+" "+mas2[i]);
        }
//        System.out.println(Arrays.toString(mas1));//для проверки
//        System.out.println(Arrays.toString(mas2));//для проверки
        in.close();
    }
}
