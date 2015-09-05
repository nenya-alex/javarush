package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name;
    int w;
    int age;
    String color;
    String  adress;
    public Cat (String name)
    {
        this.name = name;
    }//Напишите тут ваш код
    public Cat (String name, int w, int age)
    {
        this.name = name;
        this.w  = w;
        this.age = age;
    }
    public Cat (String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Cat (int w, String color)
    {
        this.w = w;
        this.color = color;
    }
    public Cat (int w, String color, String adress)
    {
        this.w = w;
        this.color = color;
        this.adress = adress;
    }//Напишите тут ваш код

}
