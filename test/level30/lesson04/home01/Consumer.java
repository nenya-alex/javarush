package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Admin on 09.07.15.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
                return;
            }

            while (true) {

                try {
                    System.out.println("Processing " + queue.take().toString());
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
        catch (Exception e)
        {
            return;
        }
    }
}
