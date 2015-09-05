package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {

//    public static void main(String[] args) throws TooShortStringException
//    {
//        System.out.println(getPartOfString("Java \t\tRush - лучший сервис обучения Java."));
//        //System.out.println(getPartOfString(null));
//    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int k = string.indexOf("\t");
        String str;
        if (k < 0)
        {
            throw new TooShortStringException();
        }
        else
        {
            str = string.substring(k+1);
            k = str.indexOf("\t");
            if (k >= 0)
            {
                str=str.substring(0,k);
            }
            else
            {
                throw new TooShortStringException();
            }
        }

        return str;
    }

    public static class TooShortStringException extends Exception {
    }
}
