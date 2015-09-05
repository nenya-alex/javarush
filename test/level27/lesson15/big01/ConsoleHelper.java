package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 19.05.2015.
 */
public class ConsoleHelper
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws IOException
    {
      return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<>();
        Dish[] mas = Dish.values();
        String str;
        writeMessage("Enter a dish from: "+ Dish.allDishesToString());
        do
        {
//            writeMessage("Enter a dish from: "+ Dish.allDishesToString());
            str = readString();

            try{
                list.add(Dish.valueOf(str));
            }
            catch (IllegalArgumentException e){
                if (!str.equals("exit"))
                ConsoleHelper.writeMessage(String.format("%s is not detected", str));
            }
//            int k = 0;
//
//            for (int i = 0; i < mas.length; i++)
//            {
//                if (str.equals(mas[i].toString()))
//                {
//                    list.add(mas[i]);
//                    k++;
//                    break;
//                }
//            }
//            if (k==0 && !str.equals("exit"))
//                writeMessage(str + " is not detected");
        }
        while (!str.equals("exit"));
        //System.out.println(list);
        return list;
    }

}
