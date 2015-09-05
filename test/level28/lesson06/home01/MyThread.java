package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 23.05.2015.
 */
public class MyThread extends Thread
{
    private static AtomicInteger counter = new AtomicInteger(1);


    public MyThread()
    {
        if (counter.get() < 10){
            setPriority(counter.getAndIncrement());
        }
        else {
            setPriority(counter.get());
            counter.set(1);
        }

    }

    public MyThread(Runnable target)
    {
        super(target);
        if (counter.get() < 10){
            setPriority(counter.getAndIncrement());
        }
        else {
            setPriority(counter.get());
            counter.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if (counter.get()<10)
        {
            int tmp = counter.get();
            counter.getAndIncrement();
            if (tmp > group.getMaxPriority())
            {
                setPriority(group.getMaxPriority());
            }
            else
            {
                setPriority(tmp);
            }

        }
        else
        {
            setPriority(group.getMaxPriority());
            counter.set(1);
            //counter.getAndIncrement();
        }
    }

    public MyThread(String name)
    {
        super(name);
        if (counter.get() < 10){
            setPriority(counter.getAndIncrement());
        }
        else {
            setPriority(counter.get());
            counter.set(1);
        }
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if (counter.get()<10)
        {
            int tmp = counter.get();
            counter.getAndIncrement();
            if (tmp > group.getMaxPriority())
            {
                setPriority(group.getMaxPriority());
            }
            else
            {
                setPriority(tmp);
            }

        }
        else
        {
            setPriority(group.getMaxPriority());
            counter.set(1);
            //counter.getAndIncrement();
        }

    }





    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if (counter.get() < 10){
            setPriority(counter.getAndIncrement());
        }
        else {
            setPriority(counter.get());
            counter.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if (counter.get()<10)
        {
            int tmp = counter.get();
            counter.getAndIncrement();
            if (tmp > group.getMaxPriority())
            {
                setPriority(group.getMaxPriority());
            }
            else
            {
                setPriority(tmp);
            }

        }
        else
        {
            setPriority(group.getMaxPriority());
            counter.set(1);
            //counter.getAndIncrement();
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if (counter.get()<10)
        {
            int tmp = counter.get();
            counter.getAndIncrement();
            if (tmp > group.getMaxPriority())
            {
                setPriority(group.getMaxPriority());
            }
            else
            {
                setPriority(tmp);
            }

        }
        else
        {
            setPriority(group.getMaxPriority());
            counter.set(1);
            //counter.getAndIncrement();
        }
    }


}
