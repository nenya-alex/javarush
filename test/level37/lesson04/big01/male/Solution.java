package com.javarush.test.level37.lesson04.big01.male;

/**
 * Created by Admin on 21.07.15.
 */
public class Solution {
    public static void main(String[] args) {
        MaleFactory maleFactory = new MaleFactory();
        System.out.println(maleFactory.getPerson(99));
        System.out.println(maleFactory.getPerson(4));
        System.out.println(maleFactory.getPerson(15));
    }
}
