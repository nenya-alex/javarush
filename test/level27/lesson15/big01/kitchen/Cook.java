package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 19.05.2015.
 */
public class Cook extends Observable implements Observer
{
    String name;

    public Cook(String name)
    {
        this.name = name;
    }


    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg)
    {
        setChanged();
        //System.out.println("Start cooking - " + arg);
        ConsoleHelper.writeMessage("Start cooking - " + arg);
        notifyObservers(arg);
    }

}
