package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/
//интересная задача
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {

//            String file1 = "C:/a.txt";
//            String file2 = "C:/b.txt";



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);

        int k1 = in1.available();
        int k2 = in2.available();
        byte[] mas1 = new byte[k1];
        byte[] mas2 = new byte[k2];
        byte[] mas3 = new byte[k1+k2];
        in1.read(mas1);
        in2.read(mas2);
        for (int i = 0; i < mas3.length; i++)
        {
            if (i<k2)
                mas3[i]=mas2[i];
            else
                mas3[i]=mas1[i-k2];
        }
//        System.out.println(Arrays.toString(mas1));
//        System.out.println(Arrays.toString(mas2));
//        System.out.println(Arrays.toString(mas3));
        FileOutputStream out = new FileOutputStream(file1);
        out.write(mas3);
        in1.close();
        in2.close();
        out.close();
        reader.close();
    }
}
