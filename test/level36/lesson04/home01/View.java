package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Admin on 20.07.15.
 */
public class View {

    private Controller controller = new Controller();
    public void fireEventShowData()
    {
        System.out.println(controller.onDataListShow());
    }
}
