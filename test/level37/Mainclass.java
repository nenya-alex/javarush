package com.javarush.test.level37;

/**
 * Created by Admin on 23.07.15.
 */
public class Mainclass {
    public static void main(String[] args) {

        int sum5 = newNewSum(5);
        System.out.println("s5 = "+sum5);

        int sum7 = newNewSum(7);
        System.out.println("s7 = "+sum7);
    }

    public static int newNewSum(int n)
    {
        int s = 0;
        for (int i = 0; i <= n; i++) {
            s=s+i;
        }
        return s;
    }
}
