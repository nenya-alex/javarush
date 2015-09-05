package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 07.11.2014.
 */
public class RussianHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 5;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - "+ Country.RUSSIA +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
