package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 07.11.2014.
 */
public class MoldovanHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 4;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - "+ Country.MOLDOVA +". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

}
