package com.javarush.test.level20.lesson10.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String filename;

    public static void main(String[] args) throws Exception
    {
        Solution s = new Solution("c:\\1.txt");
        s.writeObject("mister");
        s.close();
        //save
        FileOutputStream fos = new FileOutputStream("c:\\2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        //load
        FileInputStream fis = new FileInputStream("c:\\2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution s2 = (Solution)ois.readObject();
        ois.close();
        s2.writeObject("hello!!!");
    }


    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(filename);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        filename = (String)in.readObject();
        stream = new FileOutputStream(filename,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
