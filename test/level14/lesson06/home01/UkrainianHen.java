package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 07.11.2014.
 */
public class UkrainianHen extends Hen  implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 10;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - "+ Country.UKRAINE +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
