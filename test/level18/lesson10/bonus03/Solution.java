package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String fileName = reader.readLine();
            //String fileName = "1.txt";
            boolean delete = true;
            //String[] args = {"-u", "19846", "Шорты пляжные синие2","159","121"};
            //String[] args = {"-d", "19846"};
            //System.out.println(Arrays.toString(args));

            if ("-u".equals(args[0]) && args.length >= 5 && args[1].length() <= 8 && args[args.length - 2].length() <= 8 && args[args.length - 1].length() <= 4)
            {
                //reader.close();
                // формируем productName(
                int argsLenght = args.length;
                String productName = "";
                for (int i = 2; i < argsLenght - 2; i++)
                {
                    productName += args[i] + " ";
                }
                productName = productName.substring(0, productName.length() - 1);
                if (productName.length() < 30)
                {
                    productName = addSpace(productName, 30 - productName.length());
                }
                else if (productName.length() > 30)
                {
                    productName = productName.substring(0, 30);
                }
                // формируем productName)

                String sId = addSpace(args[1], 8 - args[1].length());
                String price = addSpace(args[argsLenght - 2], 8 - args[argsLenght - 2].length());
                String qantity = addSpace(args[argsLenght - 1], 4 - args[argsLenght - 1].length());
                String result = sId + productName + price + qantity;// + "\r\n";

                modificate(args, fileName, result, !delete);

            } else if ("-d".equals(args[0]) && args.length == 2 && args[1].length() <= 8)
            {
                //reader.close();
                modificate(args, fileName, "", delete);
            } else
            {
                return;
            }
        }
        catch (IOException e)
        {
//            System.out.println(e);
//            e.printStackTrace();
        }
    }

    private static void modificate(String[] args, String fileName, String result, boolean delete) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        //OutputStreamWriter writer;
        ArrayList<String> buffer = new ArrayList<>();
        ArrayList<String> buffer1 = new ArrayList<>();
        boolean productWasFound = false;
        String s;
        while (reader.ready())
        {
            s = reader.readLine();
            buffer.add(s);
            //System.out.println(s);
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        //System.out.println(buffer);
        for (String str: buffer)
        {
            String sId = str.substring(0, 8);
            sId = sId.trim();
            //System.out.println(sId);
            //System.out.println(args[1].equals(sId));
            if (!delete)
            {
                if (!args[1].equals(sId))
                {
                    buffer1.add(str);
                    productWasFound = true;
                }
                else
                {
                    buffer1.add(result);
                    productWasFound = true;
                }
            }
            else
            {
                if (!args[1].equals(sId))
                {
                    buffer1.add(str);
                    productWasFound = true;
                }
            }

        }
        reader.close();
        //System.out.println(buffer1);
        if (productWasFound)
        {
            //writer = new OutputStreamWriter(new FileOutputStream(fileName));
            for (int i = 0; i < buffer1.size()-1; i++)
            {
                writer.write(buffer1.get(i));
                writer.flush();
                writer.newLine();
            }
            writer.write(buffer1.get(buffer1.size()-1));
            writer.close();
        }
    }

    private static String addSpace(String s, int count)
    {
        for (int i = 0; i < count; i++)
        {
            s += " ";
        }
        return s;
    }

}

