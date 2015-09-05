package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter
{
    FileOutputStream fis;
    public AdapterFileOutputStream(FileOutputStream fis)
    {
        this.fis=fis;
    }
    @Override
    public void flush() throws IOException
    {
        fis.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        //char[] ch = s.toCharArray();
        byte[] bt = s.getBytes();
        fis.write(bt);
    }

    @Override
    public void close() throws IOException
    {
        fis.close();
    }
}

