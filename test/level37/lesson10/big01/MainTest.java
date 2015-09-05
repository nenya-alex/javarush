package com.javarush.test.level37.lesson10.big01;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 22.07.15.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Integer> list = Arrays.asList(3,4,5);
        AmigoSet<Integer> set = new AmigoSet<>(list);
        set.add(1);
        set.add(2);
        set.add(2);
//        System.out.println(set);
//        System.out.println(set.size());
//        System.out.println(set.isEmpty());
//        set.clear();
//        System.out.println(set.isEmpty());
//        System.out.println(set);
//        Iterator<Integer> it = set.iterator();
//        while (it.hasNext())
//        {
//            System.out.println(it.next());
//        }
//        System.out.println(set.remove(1));
//        System.out.println(set);
//        AmigoSet<Integer> newSet = (AmigoSet<Integer>) set.clone();
//        set.add(6);
//        System.out.println(newSet);
        System.out.println(set);


        System.out.println("Serializing...");
        FileOutputStream fileOutput = new FileOutputStream("1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(set);
        fileOutput.close();
        outputStream.close();

        set.add(6);
        System.out.println(set);

        System.out.println("Deserializing...");
        FileInputStream fiStream = new FileInputStream("1.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object newSet = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        //AmigoSet<Integer> newSet = (AmigoSet<Integer>) ois.readObject();
        System.out.println( newSet);
        System.out.println(set);
    }
}
