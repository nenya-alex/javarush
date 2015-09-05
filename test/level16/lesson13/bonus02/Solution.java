package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static T1 t1 = new T1();
    static T2 t2 = new T2();
    static T3 t3 = new T3();
    static T4 t4 = new T4();
    static T5 t5 = new T5();
    static
    {
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);
    }
}
class T1 extends Thread
{
    public void run()
    {
        while (true)
        {

        }
    }
}
class T2 extends Thread
{
    public void run()
    {
        try
        {
            throw new InterruptedException();
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
    }
}
class T3 extends Thread
{
    public void run()
    {
        while (true)
        {

            try
            {
                System.out.println("Ура");
                sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
class T4 extends Thread implements Message
{
    public void run()
    {
        while (!isInterrupted()){
        }
    }
    @Override
    public void showWarning()
    {
        this.interrupt();
        try{
            this.join();
        } catch (Exception e){}
    }
}
class T5 extends Thread
{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void run()
    {
        int S=0;
        String s = null;
        try
        {
            s = reader.readLine();
            while (!s.equals("N"))
            {
                int s1 = Integer.parseInt(s);
                S=S+s1;
                s=reader.readLine();
            }
            System.out.println(S);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}