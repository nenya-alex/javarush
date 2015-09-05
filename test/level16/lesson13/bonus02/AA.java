package com.javarush.test.level16.lesson13.bonus02;

import com.javarush.test.level16.lesson13.bonus02.Solution;

/**
 * Created by Alex on 27.12.2014.
 */
public class AA
{
    public static void main(String[] args) throws InterruptedException {
        Solution ss = new Solution();
//        for (int i = 0; i < ss.threads.size(); i++)
//        {
//            ss.threads.get(i).start();
//        }

        T4 t4= new T4();

        ss.threads.get(3).start();
        t4.showWarning();
        System.out.println(ss.threads.get(3).isAlive());
    }
}
