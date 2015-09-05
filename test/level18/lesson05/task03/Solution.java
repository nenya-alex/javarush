package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out2 = new FileOutputStream(file2);
        FileOutputStream out3 = new FileOutputStream(file3);
        byte[] mas1;
        byte[] mas2;
        if (in.available()%2!=0)
        {
            mas1 = new byte[in.available()/2+1];
            mas2 = new byte[in.available()/2];
        }
        else
        {
            mas1 = new byte[in.available()/2];
            mas2 = new byte[in.available()/2];
        }
        if (in.available()>0)
        {
            int count=in.read(mas1);
            //System.out.println(Arrays.toString(mas1));
            out2.write(mas1,0,count);
        }
        if (in.available()>0)
        {
            int count=in.read(mas2);
            //System.out.println(Arrays.toString(mas2));
            out3.write(mas2,0,count);
        }
        reader.close();
        in.close();
        out2.close();
        out3.close();
    }
}
