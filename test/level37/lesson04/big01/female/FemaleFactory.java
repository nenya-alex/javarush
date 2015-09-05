package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Admin on 21.07.15.
 */
public class FemaleFactory implements AbstractFactory{
    public Human getPerson(int age)
    {

        if (age > 19 )
            return new Woman();
        else
        if (age <=12)
            return new KidGirl();
        else
            return new TeenGirl();

    }
}
