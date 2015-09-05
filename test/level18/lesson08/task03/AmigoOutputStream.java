package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws IOException
    {

        super(fileName);

        this.fileOutputStream=fileOutputStream;
    }


    public static void main(String[] args) throws IOException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    @Override
    public FileChannel getChannel()
    {
        return fileOutputStream.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }
    @Override
    public void close() throws IOException
    {
        fileOutputStream.flush();
        fileOutputStream.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fileOutputStream.close();
    }

    @Override
    public void write(int b) throws IOException
    {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fileOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException
    {
        fileOutputStream.flush();
    }


}

