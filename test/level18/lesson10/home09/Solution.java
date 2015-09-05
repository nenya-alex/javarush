package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/
// опять не плохая задача
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        while (true)
        {
            try
            {
                file = reader.readLine();
                FileInputStream fileReader = new FileInputStream(file);
            }
            catch (FileNotFoundException e)
                {
                    System.out.println(file);

                    reader.close();
                    break;
                }

        }

    }
}
