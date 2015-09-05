package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
//import com.javarush.test.level27.lesson15.big01.kitchen.Waiter;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

/**
 * Created by Alex on 19.05.2015.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);

        Waitor waitor = new Waitor();
//        Waiter waiter = new Waiter();
        cook.addObserver(waitor);

        tablet.createOrder();

    }
}
