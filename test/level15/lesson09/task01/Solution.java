package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
static
{
    labels.put((double)1,"k");
    labels.put(2.0,"k1");
    labels.put((double)3/4,"k2");
    labels.put(-4.6,"k3");
    labels.put(5.325,"k4");
}
    public static void main(String[] args)
    {
        //Iterator<Map.Entry<Double, String>> iterator = labels.entrySet().iterator();

        System.out.println(labels);
    }
}
