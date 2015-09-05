package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/
//задача хорошая, почти  не берется. Все работает коректно, тесты проходит, но не принимается
//public class Solution {
//    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
//
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file;
//            while (!"exit".equals(file = reader.readLine()))
//            {
//                ReadThread rt = new ReadThread(file);
//                rt.start();
//                try
//                {
//                    rt.join();
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        //System.out.println(resultMap);
//        reader.close();
//    }
//
//    public static class ReadThread extends Thread
//    {
//        String fileName;
//        public ReadThread(String fileName)
//        {
//            this.fileName = fileName;
//        }
//        public void run()
//        {
//                try
//                {
//                    BufferedReader  fileIn = new BufferedReader( new InputStreamReader( new FileInputStream( fileName), "Cp1251" ) );
//                    String s;
//                    ArrayList<String> list = new ArrayList<String>();
//                    while((s=fileIn.readLine())!=null)
//                    {
//                        list.add(s);
//                    }
//                    String ss= "";
//                    for (int i = 0; i < list.size(); i++)
//                    {
//                        ss=ss+list.get(i).toString();
//                    }
//                    System.out.println(ss);
//                    char[] ch = ss.toCharArray();
//
//                    //System.out.println(Arrays.toString(ch));
//                    //System.out.println(list);
//                    //System.out.println(list.get(0).length());
//                    //FileInputStream stream = new FileInputStream(fileName);
//                    //byte[] mas = new byte[stream.available()];
//                    int[] mas1 = new int[ch.length];
//                    int[] mas2 = new int[ch.length];
//                    int[] mas3 = new int[ch.length];
//                    //stream.read(mas);
//
//
//                    for (int i = 0; i < ch.length; i++)
//                    {
//                        mas1[i] = (int) ch[i];
//                    }
//                    //System.out.println("s = "+s);
//                    //System.out.println(mas.length+" "+s.length());
//                    //System.out.println(Arrays.toString(mas1));
//                    //System.out.println(mas.length);
//                    //System.out.println(Arrays.toString(mas1));
//                    for (int i = 0; i < mas1.length-1; i++)
//                    {
//                        int count=1;
//                        for (int j = i+1; j < mas1.length; j++)
//                        {
//                            if (mas1[i]>=0 && mas1[i]==mas1[j])
//                            {
//                                mas1[j]=-1;
//                                count++;
//                            }
//                        }
//                        mas3[i]=mas1[i];
//                        mas2[i]=count;
//                    }
//                    int max=0;
//                    for (int i = 0; i < mas2.length; i++)
//                    {
//                        if (mas2[i]>max)
//                            max=mas2[i];
//                    }
//                    for (int i = 0; i < mas3.length; i++)
//                    {
//                        if (mas2[i]==max)
//                        {
//                            //System.out.print(mas3[i]+" ");
//                            resultMap.put(fileName, mas3[i]);
//                        }
//
//
//                    }
//                    //System.out.println(Arrays.toString(mas));
//                    //System.out.println(Arrays.toString(mas1));
//                    //System.out.println(Arrays.toString(mas2));
//
//                    fileIn.close();
//
//                }
//                catch (FileNotFoundException e)
//                {}
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//
//
//        }
//        // implement file reading here - реализуйте чтение из файла тут
//    }
//}
//списано и доработано. В таком виде принято
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        try{
            String fileName = bufferedReader.readLine();
            while (!fileName.equals("exit"))
            {
                list.add(fileName);
                fileName = bufferedReader.readLine();

            }
            bufferedReader.close();
            for(String s : list){
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();
            }
        }catch (Exception e){}

         //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try{
                FileInputStream fileReader = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (fileReader.available()>0){
                    int data = fileReader.read();//странные какие-то значения получаются на кирилических символах
                    //System.out.println("fileReader.read() = "+fileReader.read());
                    //System.out.println(data);
                    list.add(data);
                }
                //System.out.println(list);
                //System.out.println(list.size());
                fileReader.close();

                int max = 0;
                int id = 0;

                for(int a = 0;a<list.size();a++){
                    int count = Collections.frequency(list, list.get(a));
                    if(count>max){ max = count; id = list.get(a);}
                }

                resultMap.put(fileName,id);

            }catch (Exception e){}
        }
    }
}