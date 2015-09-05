package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        Iterator<Cat> iterator = cats.iterator();  //получение итератора для множества

        //while (iterator.hasNext())           //проверка, есть ли ещё элементы

        //{
        //    Cat text = iterator.next();   //получение текущего элемента и переход на следующий
        //    System.out.println(text);
        //}

        cats.remove(iterator.next());
        //Написать тут ваш код. step 3 - пункт 3
        //for (Cat text : cats)
        //{
        //    System.out.println(text);
        //}
        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> set = new HashSet<Cat>();
        //Cat cat1 = new Cat("r");
        //set.add(cat1);
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());

        //Написать тут ваш код. step 2 - пункт 2
        return (HashSet<Cat>) set;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> iterator = cats.iterator();  //получение итератора для множества

        while (iterator.hasNext())           //проверка, есть ли ещё элементы

        {
            Cat text = iterator.next();   //получение текущего элемента и переход на следующий
            System.out.println(text);
        }

        //for (Cat text : cats)
        // {
        //     System.out.println(text);
        // }// step 4 - пункт 4
    }
    public static class Cat
    {
        //String name;
        //  Cat (String name)
        //  {
        //      this.name = name;
        //  }
    }
    // step 1 - пункт 1
}
