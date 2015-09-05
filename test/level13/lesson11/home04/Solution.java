package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
// Правильно работающая программа, принятая
/*
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //InputStream in = new FileInputStream(reader.readLine());
        OutputStream out = new FileOutputStream(reader.readLine());
        ArrayList<String> list = new ArrayList<String>(){};
        for (;true;)
        {
            String s = reader.readLine();
            list.add(s+" ");
            if (s.equals("exit"))
            {break;}

        }
        for (String s: list)
        {
            out.write(s.getBytes());
        }
        out.close();
    }
}
*/
//Второй способ
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file  = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        for (;true;)
        {
            String s = reader.readLine();
            writer.write(s);
            writer.newLine();
            if (s.equals("exit"))
            {break;}

        }
        writer.close();
        String s = reader1.readLine();
        while (s!=null)
        {
            System.out.println(s);
            s = reader1.readLine();
        }


    }
}