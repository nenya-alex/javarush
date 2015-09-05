package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "C:/1.txt";
//        String file2 = "C:/2.txt";
        reader.close();
        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        int i=0;
        while (fr.ready())
        {
            int k = fr.read();
            i++;
            if(i%2==0)
            {
                fw.write(k);
            }
        }
        fr.close();
        fw.close();
    }
}
