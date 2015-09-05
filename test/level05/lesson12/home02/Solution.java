package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //String name = null;
        //int age;
        //String address = null;
        Man man1 = new Man("Bob", 32, "Kiev");
        Man man2 = new Man("Bobyk", 24, "Moskow");
        Woman woman1 = new Woman("Anna", 22, "Nezhin");
        Woman woman2 = new Woman("Nat", 33, "London");
        // Создай по два объекта каждого класса тут
        System.out.println(man1.name + " "+ man1.age+" "+man1.address);
        System.out.println(man2.name + " "+ man2.age+" "+man2.address);
        System.out.println(woman1.name + " "+ woman1.age+" "+woman1.address);
        System.out.println(woman2.name + " "+ woman2.age+" "+woman2.address);
        // Выведи их на экран тут
    }
    public static class Man
    {
        String name;
        int age;
        String address;
        Man (String name, int age, String address)
        {
            this.address = address;
            this.age = age;
            this.name = name;
        }
        Man (String name)
        {
            //this.address = address;
            //this.age = age;
            this.name = name;
        }
        Man (String name, int age)
        {
            //this.address = address;
            this.age = age;
            this.name = name;
        }
        Man ( int age, String address)
        {
            this.address = address;
            this.age = age;
            // this.name = name;
        }

    }
    public static class Woman
    {
        String name;
        int age;
        String address;
        Woman (String name, int age, String address)
        {
            this.address = address;
            this.age = age;
            this.name = name;
        }
        Woman (String name)
        {
            //this.address = address;
            //this.age = age;
            this.name = name;
        }
        Woman (String name, int age)
        {
            //this.address = address;
            this.age = age;
            this.name = name;
        }
        Woman ( int age, String address)
        {
            this.address = address;
            this.age = age;
            // this.name = name;
        }

    }   // Напиши тут свои классы
}
