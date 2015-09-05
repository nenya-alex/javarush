package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable
{
    public static void main(String[] args)
    {
        System.out.println(new Solution(4));

        try
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file.txt"));
            output.writeObject(new Solution(4));
            output.close();

            ObjectInputStream input = new ObjectInputStream(new FileInputStream("file.txt"));
            Solution load = (Solution) input.readObject();
            input.close();
            System.out.println(load.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

//    public Solution()
//    {
//    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
