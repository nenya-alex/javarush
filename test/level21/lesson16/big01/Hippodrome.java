package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Alex on 20.03.2015.
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public Horse getWinner()
    {
        double max=0;
        int k = 0;
        for (int i = 0; i < horses.size(); i++)
        {
            if (horses.get(i).getDistance()>max)
            {
                max = horses.get(i).getDistance();
                k=i;
            }
        }

        return horses.get(k);
    }
    public void printWinner()
    {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move()
    {
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).move();
        }
    }

    public void print()
    {
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse1 = new Horse("Atlant", 3, 0);
        Horse horse2 = new Horse("Bucefall", 3, 0);
        Horse horse3 = new Horse("Cezar", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        try
        {
            game.run();
            game.printWinner();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    }
