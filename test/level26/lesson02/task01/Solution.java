package com.javarush.test.level26.lesson02.task01;


import java.util.Arrays;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

//    public static void main(String[] args)
//    {
//        Integer[] mas = {12, 98, -54, 124, -11, 0, 77, 21, 26, -53, -98, -21, 14, 1};
//        System.out.println(Arrays.toString(sort(mas)));
//    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        Integer[] mas = new Integer[array.length];
        int mediana;
        if (array.length%2 == 0)
        {
            mediana = (array[array.length/2-1]+array[array.length/2])/2;
        }
        else {
            mediana = array[array.length/2];
        }
        //implement logic here
        //System.out.println(mediana);
        for (int i = 0; i < array.length; i++)
        {
            mas[i] = Math.abs(mediana - array[i]);
        }
//        System.out.println("mas before sort: "+Arrays.toString(mas));
//        System.out.println("arr before sort: "+Arrays.toString(array));
        for (int i = 0; i < mas.length-1; i++)
        {
            for (int j = i+1; j < mas.length; j++)
            {
                if (mas[i] > mas[j])
                {

                        int tmp = mas[j];
                        mas[j] = mas[i];
                        mas[i] = tmp;

                        int tmp1 = array[j];
                        array[j] = array[i];
                        array[i] = tmp1;


                }
            }
        }
//        System.out.println("mas after sort: "+Arrays.toString(mas));
//        System.out.println("arr after sort: "+Arrays.toString(array));
        return array;
    }
}
