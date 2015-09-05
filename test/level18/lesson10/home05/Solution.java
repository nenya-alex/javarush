package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//задача офигенная!!! но в таком виде не принята, хотя работает правильно.
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
////            String file1 = "C:/a.txt";//для проверки
////            String file2 = "C:/b.txt";
//
//
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//        FileInputStream in = new FileInputStream(file1);
//        ArrayList<Byte> list = new ArrayList<Byte>();
//        ArrayList<Byte> list1 = new ArrayList<Byte>();
//        int k = in.available();
//        byte[] mas = new byte[k];
//        in.read(mas);
//        for (int i = 0; i < mas.length; i++)
//        {
//            list.add(mas[i]);
//        }
//        //System.out.println(list);//для проверки
//        for (int i = 0; i < list.size(); i++)
//        {
//            if (list.get(i)==46)
//            {
//                if (list.get(i+1)>=53)
//                {
//                    int j=i-1;
//                    do
//                    {
//                        if (j-1<0)
//                        {
//                            if (list.get(j)==57)
//                            {
//                                list.set(0, (byte) 48) ;
//                                list.add(0,(byte) 49);
//                                i++;
//                            }
//                            else
//                            {
//                                list.set(j,(byte) (list.get(j)+1)) ;
//                            }
//                            break;
//                        }
//                        else
//                        {
//                            if (list.get(j)==57)
//                            {
//                                list.set(j,(byte) 48) ;
//                                if (list.get(j-1)==32)
//                                    list.add(j,(byte) 49) ;
//                                j--;
//                                i++;
//                            }
//                            else
//                            {
//                                list.set(j,(byte) (list.get(j)+1)) ;
//                                break;
//                            }
//                        }
//
//                    }
//                    while (list.get(j)!=32);
//                }
//
//            }
//
//        }
//        //System.out.println(list);//для проверки
//        byte[] mas1 = new byte[list.size()];
//        for (int i = 0; i < list.size(); i++)
//        {
//            if (list.get(i)==46)
//            {
//                int j=i-1;
//                do
//                {
//                    if (j-1<0)
//                    {
//                        mas1[j]= list.get(j);
//                        break;
//                    }
//                    else
//                    {
//                        mas1[j]= list.get(j);
//                        j--;
//
//                    }
//
//                }
//                while (list.get(j)!=32);
//            }
//            else if (list.get(i)==32)
//            {
//                mas1[i] =(byte) 32;
//            }
//
//        }
//        //System.out.println(Arrays.toString(mas1));//для проверки
//        for (int i = 0; i < mas1.length; i++)
//        {
//            if (mas1[i]!=0)
//            {
//                list1.add(mas1[i]);
//            }
//        }
//        //System.out.println(list1);//для проверки
//        byte[] mas2 = new byte[list1.size()];
//        for (int i = 0; i < list1.size(); i++)
//        {
//            mas2[i]=list1.get(i);
//        }
//        //System.out.println(Arrays.toString(mas2));//для проверки
//        FileOutputStream out = new FileOutputStream(file2);
//        out.write(mas2);
//        in.close();
//
//        out.close();
//        reader.close();
//    }
//}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());

        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);


        while(in.available() > 0){
            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(getInput(data));
        }


        in.close();
        out.close();

    }

    private static byte[] getInput(byte[] data){

        StringBuilder builder = new StringBuilder();
        String[] s = new String(data).split(" ");
        //System.out.println(Arrays.toString(s));
        byte[] res;
        long[] tmp = new long[s.length];

        for(int i = 0; i < s.length; i++){
            tmp[i] = Math.round(Double.valueOf(s[i]));
        }
        //System.out.println(Arrays.toString(tmp));
        for(long i : tmp){
            builder.append(i);
            builder.append(" ");
        }

        res = builder.toString().getBytes();

        return res;
    }
}
