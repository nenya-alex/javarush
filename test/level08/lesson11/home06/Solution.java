package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код

        Human ded1 = new Human("A", true, 78);
        Human ded2 = new Human("B", true, 77);
        Human bab1 = new Human("C", false, 66);
        Human bab2 = new Human("D", false, 65);
        Human otec = new Human("E", true, 45);
        Human mat = new Human("F", false, 40);
        Human det1 = new Human("G", true, 20);
        Human det2 = new Human("H", false, 18);
        Human det3 = new Human("I", true, 14);
        ArrayList<Human> children = new ArrayList<Human>();

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());
        System.out.println(otec.toString());
        System.out.println(mat.toString());
        System.out.println(det1.toString());
        System.out.println(det2.toString());
        System.out.println(det3.toString());
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        /*
        children.add(det1);
        children.add(det2);
        children.add(det3);
        children.add(otec);
        children.add(mat);
        */
        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age  = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
