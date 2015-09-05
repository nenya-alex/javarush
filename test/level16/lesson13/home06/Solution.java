package com.javarush.test.level16.lesson13.home06;

/* Создание по образцу
Разберись, как работает программа.
По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения
в нормальном порядке - от 1 до number
*/
// хорошая задача
public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new CountDownRunnable("было");

        new CountUpRunnable("стало");
    }

    //Add your code below - добавьте код ниже
    public static class CountUpRunnable implements Runnable{
        private int countIndexUp = Solution.number;
        private Thread t;
        public CountUpRunnable(String name) {
            t = new Thread(this, name);
            t.start();
//            try
//            {
//                t.join();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
        }

        @Override
        public void run()
        {
            try {
                countIndexUp=1;
//                for (int i = 0; i < countIndexUp; i++)
//                {
//                    countIndexUp = countIndexUp -1;
//                    System.out.println(countIndexUp);
//
//                }
                while (true)
                {
                    System.out.println(toString());
                    //System.out.println(countIndexUp);
                     countIndexUp += 1;

                   // System.out.println(toString());
                    Thread.sleep(500);
                        if (countIndexUp  == Solution.number+1) return;
                }

            }
            catch (InterruptedException e) {
            }
        }
        public String toString() {
            return t.getName() + ": " + countIndexUp;
        }
    }

    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;
        private Thread t;

        public CountDownRunnable(String name) {
            t = new Thread(this, name);
            t.start();
//            try
//            {
//                t.join();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return t.getName() + ": " + countIndexDown;
        }
    }
}
