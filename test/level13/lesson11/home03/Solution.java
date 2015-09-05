package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;
//Правильно работающая программа(Принята ДжаваРаш)
/*
public class Solution
{
    public static void main(String[] args) throws IOException

    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        InputStream in = new FileInputStream(f);
        OutputStream out = new PrintStream(System.out);
        while (in.available()>0)
        {
            out.write(in.read());
        }
        in.close();
        out.close();
    }
}
*/
//Второй способ без потоков
public class Solution
{
    public static void main(String[] args) throws IOException

    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(f));
        String f1 = reader1.readLine();

        while (f1!=null)
        {
            System.out.println(f1);
            f1 = reader1.readLine();
        }

    }
}