package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
//    public static void main(String[] args) {
//        String [] mas = getTokens("level22.lesson13.task01", ".");
//        System.out.println(Arrays.toString(mas));
//    }
    public static String [] getTokens(String query, String delimiter)
    {
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            list.add(tokenizer.nextToken());
        }
        String [] mas = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            mas[i] = list.get(i);
        }
        return mas;
    }
}
