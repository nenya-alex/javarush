package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 26.05.2015.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        //List<Vacancy> list = new ArrayList<>();

        Document doc = null;
        try
        {
            doc = Jsoup.connect(URL_FORMAT).get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        doc.html();
        return null;
    }


}
