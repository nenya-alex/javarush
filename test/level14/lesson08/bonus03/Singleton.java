package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Alex on 10.11.2014.
 */
public class Singleton
{
    private static Singleton a = new Singleton();
    private Singleton()
    {

    }
    static Singleton getInstance()
    {

        return a;
    }
}
