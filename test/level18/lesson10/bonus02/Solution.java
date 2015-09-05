package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
//условие задачи написано так, что фиг поймешь, что от тебя требуется! такой код не принимается
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Solution {
//    public static void main(String[] args) throws Exception
//    {
//        //String[] args = {"-c","Шорты пляжные olo Шорты пляжные","15.12124587999","12"};
//        if (args.length==4)
//        {
//            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
//            String file1 = reader.readLine();
//            //String file1 = "2.txt";
//            String s;
//            File fileF = new File(file1);
//            int max=max(fileF);
//            //System.out.println(max);
//            double price;
//            int quantity;
//            if (max<99999999)
//            {
////                if (args[1].length()>30)
////                {
////                    args[1]=args[1].substring(0,30);
////                }
//                if (args[2].length()>8)
//                {
//                    args[2]=args[2].substring(0, 8);
//                }
//                try
//                {
//                    price = Double.parseDouble(args[2]);
//                    if (price<0)
//                        return;
////                    double x = price*100;
////                    x=Math.round(x);
////                    price = x/100;
////                    System.out.println(price);
//                }
//                catch (Exception e)
//                {
//                    return;
//                }
//                if (args[3].length()>4)
//                {
//                    args[3] = args[3].substring(0,4);
//                }
//                try
//                {
//                    quantity = Integer.parseInt(args[3]);
//                    if (quantity<0)
//                        return;
//                }
//                catch (Exception e)
//                {
//                    return;
//                }
//
//                s=String.format("%-8d%-30.30s%-8.2f%-4d", (max+1),args[1],price,quantity);
//                //System.out.println(s);
//                BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileF, true));
//                if (fileF.length()!=0)
//                {
//                    fileOut.newLine();
//                    fileOut.write(s);
//                }
//                else
//                {
//                    fileOut.write(s);
//                }
//                fileOut.close();
//            }
//            else
//            {
//                return;
//            }
//        }
//        else
//        {
//            return;
//        }
//    }
//    public static int max (File fileF) throws IOException
//    {
//        BufferedReader fileIn = new BufferedReader(new FileReader(fileF));
//        String s=fileIn.readLine();
//        int max;
//        if (s!=null)
//        {
////            if (!s.isEmpty())
////            {
//                ArrayList<String> list = new ArrayList<String>();
//                ArrayList<String> list1 = new ArrayList<String>();
//                ArrayList<Integer> list2 = new ArrayList<Integer>();
//                list.add(s);
//                while((s=fileIn.readLine())!=null)
//                {
//                    list.add(s);
//                }
//                fileIn.close();
//                //System.out.println(list);
//                for (int i = 0; i < list.size(); i++)
//                {
//                    list1.add((list.get(i).substring(0, 8)));
//                }
//                for (int i = 0; i < list1.size(); i++)
//                {
////                if (list1.get(i).endsWith(" "))
////                    list1.set(i, list1.get(i).substring(0, list1.get(i).indexOf(" ")));
//                    list1.set(i, list1.get(i).trim());
//                }
//                //System.out.println(list1);
//                for (int i = 0; i < list1.size(); i++)
//                {
//                    if(list1.get(i).startsWith("\uFEFF"))
//                    {
//                        list1.set(i, list1.get(i).substring(1, list1.get(i).length()));
//                    }
//                    list2.add(Integer.parseInt(list1.get(i)));
//                }
//
//                //System.out.println(list2);
//                max = Collections.max(list2);
//                //System.out.println(max);
////            }
////            else
////            {
////                max=0;
////            }
//        }
//        else
//        {
//            max=0;
//        }
//        return max;
//    }
//}
//списано!!! я офигиваю с красоты этого решения!!!!!
import java.io.*;
import java.util.ArrayList;

public class Solution {

    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(name));
        int max = 0;
        if (args[0].equals("-c"))
        {
            while (file.ready())
            {
                String str = file.readLine();
                list.add(str);
                int y = Integer.parseInt(str.substring(0,8).replaceAll(" ",""));
                if (y > max) max = y;

            }
            max++;
            file.close();
            BufferedWriter fileWR = new BufferedWriter(new FileWriter(name));
            for (int i = 0; i < list.size();i++)
            {
                if (list.get(i).equals("")) continue;
                fileWR.write(String.format("%s%n", list.get(i)));
            }
            String productname = args[1];
            for (int l = 2; l < args.length-2; l++)
                productname +=" " + args[l];
            fileWR.write(String.format("%-8.8s%-30.30s%-8.8s%-4.4s%n",String.valueOf(max),productname,args[args.length-2],args[args.length-1]));
            fileWR.close();
        }
    }
}