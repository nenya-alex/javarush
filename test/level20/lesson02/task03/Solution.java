package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Map<String, String> properties1 = new HashMap<>();
    public static Map<String, String> properties2 = new HashMap<>();

    public static void main(String[] args) throws Exception
    {
        properties1.put("A", "aaaaa");
        properties1.put("B", "bbbbb");
        properties1.put("C", "abcde");
        properties1.put("D", "ddeert");
        properties1.put("E", "eedcfr");
        File your_file_name = new File("111.txt");
        OutputStream outputStream = new FileOutputStream(your_file_name, true);
        InputStream inputStream = new FileInputStream(your_file_name);

        //new Solution().save(outputStream);
        //new Solution().load(inputStream);
        new Solution().fillInPropertiesMap();
        //System.out.println(properties2.size());
        for (Map.Entry<String, String> it: properties.entrySet())
        {
            String str = it.getKey()+" = "+it.getValue();
            System.out.println (str);
        }
    }

    public void fillInPropertiesMap() throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        //String fileName = "111.txt";
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        while (readerFile.ready())
        {
            String str = readerFile.readLine();
            //System.out.println(str);
            if (!str.startsWith("#") && !str.startsWith("!"))
            {
//                System.out.println(str);
                if (str.endsWith("\\"))
                {
                    str = str.replaceAll("\\\\", "");
                    String s;
                    while ((s = readerFile.readLine()).endsWith("\\"))
                    {
                        str = str+s.replaceAll("\\\\","").trim()+" ";
                    }
                    str=str+s.replaceAll("\\\\", "").trim();
                    //System.out.println(str);
                    int k = str.indexOf("=");
                    int n = str.indexOf(":");
                    if(k>0)
                    {
                        String key = str.substring(0, k).trim();
                        String value = str.substring(k+1).trim();
                        properties.put(key, value);
                    }
                    else if (n>0)
                    {
                        String key = str.substring(0, n).trim();
                        String value = str.substring(n+1).trim();
                        properties.put(key, value);
                    }

                }
                else
                {
                    str = str.replaceAll("\\\\", "");
                    int k = str.indexOf("=");
                    int n = str.indexOf(":");
                    if(k>0)
                    {
                        String key = str.substring(0, k).trim();
                        String value = str.substring(k+1).trim();
                        properties.put(key, value);
                    }
                    else if (n>0)
                    {
                        String key = str.substring(0, n).trim();
                        String value = str.substring(n+1).trim();
                        properties.put(key, value);
                    }
                }
            }
        }
        readerFile.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream, true);
        for (Map.Entry<String, String> it: properties.entrySet())
        {
            String str = it.getKey()+" = "+it.getValue();
            writer.println(str);
        }
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready())
        {
            String str = reader.readLine();
            int k = str.indexOf("=");
            String key = str.substring(0, k).trim();
            String value = str.substring(k+1).trim();
            properties.put(key, value);
        }
    }
}
