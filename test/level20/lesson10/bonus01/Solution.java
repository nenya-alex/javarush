package com.javarush.test.level20.lesson10.bonus01;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
// программа работает, но долго и потому не принимается
//public class Solution {
//
//    public static void main(String[] args) {
//
//        long memoryStart = Runtime.getRuntime().freeMemory();
//        Long t0 = System.currentTimeMillis();
//        int[] mas = getNumbers(820915);
//        long memoryEnd = Runtime.getRuntime().freeMemory();
//        long memoTaken = memoryStart - memoryEnd;
//
//        Long t1 = System.currentTimeMillis();
//        System.out.println(("Time need to create the arrray = " + (t1 - t0)/10));
//        System.out.println(("Memory need to create the arrray = " + memoTaken));
//        System.out.println(Arrays.toString(mas));
//    }
//
//    public static int[] getNumbers(int N) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        for (int i = 1; i < N; i++)
//        {
//            int k = Integer.toString(i).length();
//            int n = i;
//            //System.out.println(n);
//            for (int j = 0; j < k; j++)
//            {
//                //System.out.println(n%10);
//                list.add(n%10);
//                n=n/10;
//            }
//            //System.out.println(list);
//            int r=0;
//            for (int j = 0; j < k; j++)
//            {
//                r= r+(int) Math.pow(list.get(j),k);
//                if (r>i)
//                    break;
//            }
//            if (i==r)
//            {
//                list1.add(i);
//            }
//            list.clear();
//        }
//        //System.out.println(list1);
//        int[] result = new int[list1.size()];
//        for (int i = 0; i < list1.size(); i++)
//        {
//            result[i] = list1.get(i);
//        }
//        return result;
//    }
//}
//списано
public class Solution {
    public static int[] getNumbers(int N)
    {
        int[] result = null;
        List<Integer> list = new ArrayList<>();
        for (int n = 1; n < N; n++)
        {
            int sum = 0, temp, r;
            int q = 0;
            temp = n;
            int length = (int) (Math.log10(n) + 1);
            while (temp != 0)
            {
                for (int i = 0; i < length; i++)
                {
                    int prod = 1;
                    r = temp % 10;
                    for (int j = 0; j < length; j++)
                    {
                        prod = prod * r;
                    }
                    sum = sum + prod;
                    temp = temp / 10;
                }
            }
            if (n == sum)
            {
                list.add(n);
            }
        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
//    public static void main(String args[])
//    {
//        long memoryStart = Runtime.getRuntime().freeMemory();
//        Long t0 = System.currentTimeMillis();
//        int[]result = getNumbers(100000000);
//        long memoryEnd = Runtime.getRuntime().maxMemory();
//        long memoTaken = memoryStart - memoryEnd;
//        System.out.println(memoTaken);
//        Long t1 = System.currentTimeMillis();
//        System.out.println("Time need to create the arrray = " + (t1 - t0));
//        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
//    }
}