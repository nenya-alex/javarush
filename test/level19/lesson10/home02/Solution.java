package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    static ArrayList<String> list = new ArrayList<String>();
    static ArrayList<Person> list2 = new ArrayList<Person>();
    public static void main(String[] args) throws IOException
    {
        //String[] args = {"C:/a.txt"};
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready())
        {
            list.add(reader.readLine());
        }
        reader.close();
        for (int i = 0; i < list.size(); i++)
        {
            list2.add(new Person(list.get(i).split(" ")[0], Double.parseDouble(list.get(i).split(" ")[1])));
        }
        for (int i = 0; i < list2.size()-1; i++)
        {
            for (int j = i+1; j < list2.size(); )
            {
                if (list2.get(i).getName().equals(list2.get(j).getName()))
                {
                    list2.set(i, new Person(list2.get(i).getName(), list2.get(i).getSal()+list2.get(j).getSal()));
                    list2.remove(j);
                }
                else
                {
                    j++;
                }
            }
        }
        Collections.sort(list2, new Person());
//        for (Person s: list2)
//        {
//            System.out.println(s.getName()+" "+s.getSal());
//        }
        System.out.println(list2.get(0).getName());
        for (int i = 1; i < list2.size(); i++)
        {
            if (list2.get(0).getSal()==list2.get(i).getSal())
            {
                System.out.println(list2.get(i).getName());
            }
        }
    }
    static class Person implements Comparator
    {
        String name;
        double sal;

        public Person()
        {
        }
        public Person(String name, double sal)
        {
            this.name = name;
            this.sal = sal;
        }

        public String getName()
        {
            return name;
        }

        public double getSal()
        {
            return sal;
        }

        @Override
        public int compare(Object o1, Object o2)
        {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;
            double d = p1.getSal()-p2.getSal();
            int k=0;
            if (d>0)
                k=-1;
            if (d<0)
            {
                k=1;
            }
            if (d==0)
                k=0;
            return k;
        }
    }

}
