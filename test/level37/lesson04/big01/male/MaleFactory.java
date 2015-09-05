package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;
import com.javarush.test.level37.lesson04.big01.male.KidBoy;
import com.javarush.test.level37.lesson04.big01.male.Man;
import com.javarush.test.level37.lesson04.big01.male.TeenBoy;

/**
 * Created by Admin on 21.07.15.
 */
public class MaleFactory implements AbstractFactory{
    public Human getPerson(int age)
    {

        if (age > 19 )
        return new Man();
        else
            if (age <=12)
                return new KidBoy();
            else
                return new TeenBoy();

    }
}
