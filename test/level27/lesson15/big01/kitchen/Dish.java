package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Alex on 19.05.2015.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString() {

        Dish[] arrayDish = Dish.values();
        StringBuilder s = new StringBuilder();
        if (arrayDish.length==0)
        {
            s.append("");
        }
        else
        {
            s.append(arrayDish[0]);
            for (int i = 1; i < arrayDish.length; i++)
            {
                s.append(", ").append(arrayDish[i]);
            }
        }
        return s.toString();
    }

}
