package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 07.05.2015.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {


    try
    {
        int i = 1;
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted())
        {

            while (true)
            {
                System.out.println("Some text for " + i);
                i++;

                    currentThread.sleep(500);

            }
        }
    }
    catch (InterruptedException e) {
    System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
}
    }
}
