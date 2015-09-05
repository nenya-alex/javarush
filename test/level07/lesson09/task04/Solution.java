package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза");
        list.add("оза");
        list.add("лира1.0"); //1
        list.add("лоза2");
        list.add("лира1.1"); //1
        list.add("лоза2.1"); //2
        list.add("роза");
        list.add("лир1.2");//0
        list.add("лоза2.2");
        list.add("роза"); //0
        list.add("лр1.3");
        list.add("лоза2.3");

        list.add("роз");
        list.add("лир1.4");//0
        list.add("лоза2.4");
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        for (int i = 0; i < list.size();)
        {

            if (list.get(i).contains("р")&&list.get(i).contains("л"))
            {i++;
            }
            else
            {
                if (list.get(i).contains("р"))
                {
                    list.remove(i);
                }
                else
                {
                    if (list.get(i).contains("л"))
                    {
                        list.add(i, list.get(i));

                    }
                    i++;i++;
                }
            }
            }

        //add your code here -  добавь код тут
        return list;
    }
}