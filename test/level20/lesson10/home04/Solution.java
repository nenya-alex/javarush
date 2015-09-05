package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.*;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
// задача поначалу кажется интересной... спутся час так и не решил
public class Solution implements Serializable {



    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("123.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        System.out.println(solution.size());
        for (Map.Entry it: solution.m.entrySet())
        {
            System.out.println(it.getKey()+" "+it.getValue());
        }
        List list = new ArrayList<>(solution.m.values());
        System.out.println(list);
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("123.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println("loadedObject.size() = "+loadedObject.size());
        System.out.println(loadedObject.getMap());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }



    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
