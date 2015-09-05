package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by Admin on 20.07.15.
 */
public class Controller
{

        private Model service = new Model();
    public List<String> onDataListShow()
    {
        return service.getStringDataList();
    }
}
