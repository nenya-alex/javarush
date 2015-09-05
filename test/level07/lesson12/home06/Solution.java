package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("A", true, 78, null, null);
        Human ded2 = new Human("B", true, 87, null, null);
        Human bab1 = new Human("C", false, 67, null, null);
        Human bab2 = new Human("D", false, 75, null, null);
        Human otec = new Human("E", true, 45, ded1, bab1);
        Human mat = new Human("F", false, 40, ded2, bab2);
        Human det1 = new Human("G", true, 25, otec, mat);
        Human det2 = new Human("H", true, 20, otec, mat);
        Human det3 = new Human("R", false, 15, otec, mat);
        System.out.println(ded1.toString());//Написать тут ваш код
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
        String name;
        boolean sex;
        int age;
        Human father;//Написать тут ваш код
        Human mother;

               public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
