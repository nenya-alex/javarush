package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    static ArrayList<String> list = new ArrayList<String>();
    static ArrayList<String[]> list2 = new ArrayList<String[]>();

    public static void main(String[] args) throws IOException
    {
        //String[] args = {"C:/a.txt"};
        String name = "";
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            list.add(reader.readLine());
        }
        reader.close();
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            list2.add(list.get(i).split(" "));
        }
        for (String[] s: list2)
        {
            //System.out.println(Arrays.toString(s));
            Calendar calendar = new GregorianCalendar(Integer.parseInt(s[s.length-1]), Integer.parseInt(s[s.length-2]) - 1, Integer.parseInt(s[s.length-3]));
            Date birthDate = calendar.getTime();
            int k = 0;
            while (k!=s.length-3)
            {
                name=name+s[k]+" ";
                k++;
            }
            name=name.substring(0,name.length()-1);
            PEOPLE.add(new Person(name, birthDate));
            name="";
        }
//        for (Person s: PEOPLE)
//        {
//            System.out.println(s.getName()+" "+s.getBirthday());
//        }

    }

}
