package com.javarush.test.level31.lesson02.home02;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

//    public static void main(String[] args) throws IOException {
//
//
//
//        String root = "C:\\A";
//
//        Solution solution = new Solution();
//
//        List<String> list =  solution.getFileTree(root);
//
//        System.out.println(list);
//
//
//
//    }

    public static List<String> getFileTree(String root) throws IOException {

        List<String> list = new ArrayList<>();
        Queue<File> queue = new ArrayDeque<>();

        File folder = new File(root);

        Collections.addAll(queue, folder.listFiles());
        //queue.add(folder);
        //System.out.println(queue);

        while (!queue.isEmpty()){
            //System.out.println(queue);
            File file = queue.poll();

            if (file.isDirectory()) {
                //System.out.println("DIR " + file.getName());
                Collections.addAll(queue, file.listFiles());
            }
            else
            {
                //System.out.println("FILE " + file.getName());
                list.add(file.getAbsolutePath());
            }
        }

        return list;

    }
}
