package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException
         {
             throw new NotSerializableException("Не сегодня!");
         }
        private void readObject(ObjectInputStream in) throws IOException
        {
            throw new NotSerializableException("Не сегодня!");
        }
    }
}
