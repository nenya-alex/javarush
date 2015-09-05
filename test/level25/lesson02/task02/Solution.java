package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {

//    public static void main(String[] args)
//    {
//        System.out.println(new Car().wheels);
//    }

        public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            String[] mas1 = loadWheelNamesFromDB();
            Wheel[] mas = Wheel.values();
            int k = 0;
            try
            {
                if (mas1.length != 4)
                    throw new IllegalArgumentException();

                for (int i = 0; i < mas1.length; i++)
                {
                    for (int j = 0; j < mas.length; j++)
                    {
                        if (mas1[i].equals(mas[j].name()))
                        {
                            k++;
                        }
                    }

                }
                if (k == mas.length)
                {
                    wheels = Arrays.asList(mas);
                }
                else
                {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.print("Это не машина");
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
