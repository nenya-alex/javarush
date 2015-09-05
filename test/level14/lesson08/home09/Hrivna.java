package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Alex on 10.11.2014.
 */
public class Hrivna extends Money
{

    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
