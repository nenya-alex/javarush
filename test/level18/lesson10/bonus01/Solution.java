package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/
// прикольная задача
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args[0].equals("-e"))
        {
                en(args[1], args[2]);
        }
        else if (args[0].equals("-d"))
        {
            de(args[1], args[2]);
        }
    }
    public static void en(String file1, String file2) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        FileInputStream in = new FileInputStream(file1);
            while (in.available()>0)
            {
                list.add(in.read());
            }
            in.close();
        //System.out.println(list2);
        //System.out.println(list2.size());
        FileOutputStream out = new FileOutputStream(file2);
        //BufferedOutputStream bos = new BufferedOutputStream(out);
        for (int i = 0; i < list.size(); i++)
        {

            out.write(list.get(i)-1);

        }
        out.close();
    }
    public static void de(String file1, String file2) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        FileInputStream in = new FileInputStream(file1);
        while (in.available()>0)
        {
            list.add(in.read());
        }
        in.close();
        //System.out.println(list2);
        //System.out.println(list2.size());
        FileOutputStream out = new FileOutputStream(file2);
        //BufferedOutputStream bos = new BufferedOutputStream(out);
        for (int i = 0; i < list.size(); i++)
        {

            out.write(list.get(i)+1);

        }
        out.close();
    }
}
