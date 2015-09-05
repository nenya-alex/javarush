package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
// бред
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream)
    {
        Object object = null;
        try
        {
            object = objectStream.readObject();
            objectStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        A newA;
        B newB;
        if (object instanceof A)
        {
            return newA = (A) object;
        }
        else
        {
            return newB = (B) object;
        }

    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
             System.out.println("inside B");
        }
    }
}
