package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }

               //Напишите тут ваш код
        ArrayList<Character> list1 = new ArrayList<Character>();
        String s = list.get(0);
        for (int i = 1; i <10 ; i++)
        {
            s = s + list.get(i);
        }
        //System.out.println(s);
        for (int i = 0; i < s.toCharArray().length; i++)
        {
            list1.add(s.charAt(i));
        }
        for (int i = 0; i < alphabet.size(); i++)
        {
            int k = 0;
            for (int j = 0; j < list1.size(); j++)
            {
                if (alphabet.get(i).equals(list1.get(j)))
                {k=k+1;}
            }
            System.out.println(alphabet.get(i)+" "+k);
        }
        /*
        for (int i = 0; i < list1.size(); i++)
        {
            System.out.println(list1.get(i));
        }
        System.out.println(s.toCharArray().length);
*/

    }

}
