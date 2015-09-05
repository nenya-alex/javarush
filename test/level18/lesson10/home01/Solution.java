package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/
// хорошая задача, я решил не самым простым способом, есть и другие мысли по поводу решения.
// пригодится таблица символов Юникода http://unicode-table.com/ru/#control-character
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream in = new FileInputStream(args[0]);
        byte[] mas = new byte[in.available()];
        int count=0;
        in.read(mas);
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i]>=65 && mas[i]<=90 || mas[i]>=97 && mas[i]<=122)
                count++;
        }
        System.out.println(count);
        in.close();
    }
}
