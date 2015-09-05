package com.javarush.test.level29.lesson09.task01;

import java.math.BigDecimal;

/* Этот странный BigDecimal
Исправьте ошибку реализации, приводящую к погрешности вычисления, в методе getValue.
Сигнатуру метода не менять. Округление не использовать.
Читайте доп. статью про особенности автобоксинга.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        BigDecimal bd1 = BigDecimal.valueOf(v1);
        //System.out.println(bd1);
        BigDecimal bd2 = BigDecimal.valueOf(v2);
        //System.out.println(bd2);
        BigDecimal bd3 = bd1.add(bd2);
        //System.out.println(bd1.add(bd2));
        return bd3;
    }
}
