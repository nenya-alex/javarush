package com.javarush.test.level27.lesson15.big01;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 19.05.2015.
 */
public class Tablet extends Observable
{
    final int number;
    Logger logger = Logger.getLogger(Tablet.class.getName());


    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {

        try
        {
            Order order = new Order(this);
            System.out.println(order);
            if (!order.isEmpty())
            {
                //ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);
            }
//            else
//                return;
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }


    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number +
                '}';
    }
}
