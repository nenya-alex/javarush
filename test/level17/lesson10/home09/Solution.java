package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines,
то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/
// все работает согласно условию!
//задача хорошая, есть хоть какой-то смысл.
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();
//        String fileName1 = "C:/a.txt";
//        String fileName2="C:/b.txt";
//        String line1, line2;

        try
        {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            readFromFile(fileName1, allLines);
            readFromFile(fileName2, forRemoveLines);

//            System.out.println(allLines);
//            System.out.println(forRemoveLines);




        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            sol.joinData();
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }
//              System.out.println(allLines);
//              System.out.println(forRemoveLines);
    }
    public static void readFromFile(String fileName, List<String> list) throws IOException
    {
        String line;
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        while ((line = readerFile.readLine())!=null)
        {
            list.add(line);
        }
        readerFile.close();
    }


    public void joinData () throws CorruptedDataException
    {

        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}