package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//Напишите тут ваш код
        String name = reader.readLine();
        String num1 = reader.readLine();
        int Num1 = Integer.parseInt(num1);
        String num2 = reader.readLine();
        int Num2 = Integer.parseInt(num2);
        System.out.println(name+" получает "+Num1+" через "+Num2+" лет.");
    }
}