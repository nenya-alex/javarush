package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/
//хорошая задача, пришлось подумать
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
//        String file1 = "C:/a.txt";
//        String file2 = "C:/b.txt";
//        String file3 = "C:/c.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream in2 = new FileInputStream(file2);
        FileInputStream in3 = new FileInputStream(file3);
        FileOutputStream out = new FileOutputStream(file1);
        int k2 = in2.available();
        int k3 = in3.available();
        byte[] mas1 = new byte[k2+k3];
        byte[] mas2 = new byte[k2];
        byte[] mas3 = new byte[k3];
        in2.read(mas2);
        in3.read(mas3);
        for (int i = 0; i < mas1.length; i++)
        {
            if (i<k2)
                mas1[i]=mas2[i];
            else
                mas1[i]=mas3[i-k2];
        }
//        System.out.println(Arrays.toString(mas2));
//        System.out.println(Arrays.toString(mas3));
//        System.out.println(Arrays.toString(mas1));
        out.write(mas1);
        in2.close();
        in3.close();
        out.close();
    }
}
