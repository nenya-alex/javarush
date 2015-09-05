package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
// Киев Вена Вашингтон Нью-Йорк Амстердам Мельбурн
// не принимается, но работает
//public class Solution {
//
//    public static List<String> list = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        //String fileName = "123.txt";
//        reader.close();
//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
//
//        while (fileReader.ready())
//        {
//            String str = fileReader.readLine();
//            if (str!=null)
//            {
//                Scanner scanner = new Scanner(str);
//                while (scanner.hasNext())
//                {
//                    list.add(scanner.next());
//                }
//                scanner.close();
//            }
//        }
//        fileReader.close();
//        Collections.sort(list);
//        String[] words = new String[list.size()];
//        for (int i = 0; i < list.size(); i++)
//        {
//            words[i] = list.get(i);
//        }
//        list.clear();
//        StringBuilder result = getLine(words);
//        System.out.println(result.toString());
//
//    }
//
//    public static StringBuilder getLine(String... words)
//    {
//        StringBuilder sb = new StringBuilder();
//
//        if (words == null || words.length == 0)
//        { return new StringBuilder(); }
//        if ("".equals(words[0]) || words.length == 1)
//        {return new StringBuilder(words[0]); }
//
//            List<String> newList = new LinkedList<>();
//            List<String> endList = new LinkedList<>();
//            //System.out.println(Arrays.toString(words));
//            for (int i = 0; i < words.length; i++)
//            {
//                list.add(words[i]);
//                newList.add(words[i]);
//            }
//            int k = list.size();
//            int i = 0, n = 0;
//            do
//            {
//                endList.clear();
//                String str = list.get(i);
//                //System.out.println(str);
//                endList.add(str);
//                int t = i;
//                //for (int t = i; t < list.size(); )
//                while (true)
//                {
//
//                    for (int j = 0; j < newList.size(); )
//                    {
//                        str = newList.get(j);
//                        if (list.get(t).endsWith(String.valueOf(str.toLowerCase().charAt(0))))
//                        {
//                            //System.out.println(str);
//                            endList.add(str);
//                            t = j;
//                            break;
//                        } else
//                        {
//                            j++;
//                        }
//                    }
//                    if (Collections.frequency(endList, str) > 1)
//                    {
//                        endList.remove(endList.size() - 1);
//                        if (endList.size() == k)
//                        {
//                            break;
//                        }
//                        endList.clear();
//                        break;
//                    }
//                }
//                //System.out.println("=============");
//                i++;
//            }
//            while (endList.size() != k);
//            for (int j = 0; j < endList.size(); j++)
//            {
//                sb.append(endList.get(j)).append(" ");
//            }
//            //System.out.println(endList);
//            sb.deleteCharAt(sb.length() - 1);
//
//
//
//        return sb;
//    }
//}
// списано
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        String www = "";
        while (scanner.hasNextLine())
        {
            www = scanner.nextLine();
        }
        StringBuilder result = getLine(www.split(" "));
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
        { return new StringBuilder(); }
        if ("".equals(words[0]) || words.length == 1)
        {return new StringBuilder(words[0]); }

        StringBuilder result = new StringBuilder();

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length; i ++)
            if (!words[i].equals(""))
                list.add(words[i]);
        while (!isOK(list))
        {
            Collections.shuffle(list);
        }
        for (String s : list)
            result.append(s+ " ");
        result.deleteCharAt(result.length()-1);
        return result;
    }
    public static boolean isOK(ArrayList<String> list)
    {
        for (int i = 0; i < list.size()-1; i++)
        {
            String first = list.get(i);
            String second = list.get(i+1);
            first = first.toLowerCase();
            second =second.toLowerCase();
            if (first.charAt(first.length()-1)!=second.charAt(0))
                return false;
        }
        return true;
    }
}
