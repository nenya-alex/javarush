package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/
//Правильное решение
/*
public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static
    {
        String stroka="\n";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME));

            do
            {
                stroka=reader.readLine();
                if(stroka!=null)
                {
                    //System.out.println(stroka);
                    lines.add(stroka);
                }
            }
            while(stroka!=null);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }





    public static void main(String[] args) throws IOException
    {
        System.out.println(lines);
    }
}
*/
//Второй способ
public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static
    {
        //String stroka="\n";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME));
            String stroka=reader.readLine();
            while(stroka!=null)
            {
                System.out.println(stroka);
                lines.add(stroka);
                stroka=reader.readLine();



            }


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }





    public static void main(String[] args) throws IOException
    {
        System.out.println(lines);
    }
}