package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //int k=0;
        String file1;
        String file2;
        ArrayList<String> list = new ArrayList<String>();
            while (!file.equals("end"))
            {
                list.add(file);
                file = reader.readLine();

            }
        //System.out.println(list);
        reader.close();
        Collections.sort(list);
        //System.out.println(list);
        file1 = list.get(0);
        File f1 = new File(file1);
        String dir = f1.getParent();
        int k=file1.lastIndexOf(".");
        file2 = file1.substring(0,k);
        File f2 = new File(file2);
        f2.createNewFile();

//        for (int i = 0; i < list.size(); i++)
//        {
//            FileInputStream fis = new FileInputStream(list.get(i));
//            k=k+fis.available();
//        }
//        int[] mas = new int[k];
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            FileInputStream in = new FileInputStream(list.get(i));
            BufferedInputStream bis = new BufferedInputStream(in);
            while (bis.available()>0)
            {
                list2.add(bis.read());
            }
            in.close();
            bis.close();
        }
        //System.out.println(list2);
        //System.out.println(list2.size());
        FileOutputStream out = new FileOutputStream(file2);
        //BufferedOutputStream bos = new BufferedOutputStream(out);
        for (int i = 0; i < list2.size(); i++)
        {

            out.write(list2.get(i));

        }
        out.close();
        //bos.close();

    }
}
