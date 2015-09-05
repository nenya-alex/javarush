package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //String[] args = {"1.txt", "12.txt"};

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        List<String>  list = new ArrayList<>();
        List<String>  list1 = new ArrayList<>();
        while (reader.ready())
        {
            list.add(reader.readLine());
        }

        for (int i = 0; i < list.size(); i++)
        {
            list1.add(new String(list.get(i).getBytes("Cp1251"), "UTF-8"));
        }
        for (int i = 0; i < list1.size(); i++)
        {
            writer.write(list1.get(i));
            writer.flush();
            writer.newLine();
        }
        reader.close();
        writer.close();
//        String s = new String(win1251TestString.getBytes("Cp1251"), "UTF-8");
//        System.out.println(s);
    }
}
