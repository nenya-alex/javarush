package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 19.05.2015.
 */
public class Order
{
    //List<Dish> listAll;
    List<Dish> dishes;
    Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime()
    {
        int k = 0;
        for (int i = 0; i < dishes.size(); i++)
        {
            k = k + dishes.get(i).getDuration();
        }
        return k;
    }

    public boolean isEmpty()
    {
        return dishes.size()==0;
    }

    public String toString()
    {
        if (dishes.size()==0)
        {
            return "";
        }
        else
        {

            return "Your order: "+dishes+" of "+tablet+", cooking time "+getTotalCookingTime()+"min";
        }

    }
}
