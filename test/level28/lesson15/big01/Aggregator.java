package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 26.05.2015.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Provider provider = new Provider(new HHStrategy());

        Controller controller = new Controller(provider);
        //System.out.println(controller);
        controller.scan();
//        final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%s";
//        String str = String.format(URL_FORMAT, "Kiev", 3);
//        System.out.println(str);
    }
}
