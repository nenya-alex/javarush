package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipPath = args[1];

//        String fileName = "C:\\A\\a.txt";
//        String zipPath = "C:\\A\\B\\B.zip";

        //if (args.length==2){
//            разархивируем данный архив в карту fileMap

            Map<ZipEntry, byte[]> fileMap = new HashMap<>();


            FileInputStream fis = new FileInputStream(zipPath);
            ZipInputStream zis = new ZipInputStream(fis);

            ZipEntry ze;

            while ((ze=zis.getNextEntry())!=null){

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }

                byte[] bytes = baos.toByteArray();

                fileMap.put(ze, bytes);

            }
//        System.out.println(Arrays.toString(new File(zipPath).getParentFile().listFiles()));

//        System.out.println(Arrays.toString(new File(zipPath).getParentFile().listFiles()));


            zis.close();
        //System.out.println(new File(new File(zipPath).getName()).delete());


            FileInputStream fis1 = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;

            while (fis1.available()>0) {
                count = fis1.read(buffer);
                baos.write(buffer, 0, count);
            }

            byte[] bytes = baos.toByteArray();



            //fileMap.put(new ZipEntry(new File(fileName).getAbsolutePath()), bytes);
            //fileMap.put(new ZipEntry("new/" + new File(fileName).getName()), bytes);



          //если в карте есть файл похожий на наш, то заменяем его, иначе - создаём новую папку new
        int k = 0, n= fileMap.size();
        for (Map.Entry<ZipEntry, byte[]> pair: fileMap.entrySet())
        {
            k++;
            if (pair.getKey().getName().equals("new/" + new File(fileName).getName()))
            {
                pair.setValue(bytes);
                break;
            }
            else
            {
                if (k==n)
                {
                    fileMap.put(new ZipEntry("new/" + new File(fileName).getName()), bytes);
                }
            }
        }

        //System.out.println(fileMap.size());

//        for (Map.Entry<ZipEntry, byte[]> pair: fileMap.entrySet())
//        {
//            System.out.println(pair.getKey()+" "+ Arrays.toString(pair.getValue()));
//        }

//            if (fileMap.containsKey(new ZipEntry("new/" + new File(fileName).getName())))
//                fileMap.put(fileToWrite.getName(), fileToWrite);
//            else {
//                fileMap.put(new ZipEntry("new/" + new File(fileName).getName()), bytes);
//            }

            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (Map.Entry<ZipEntry, byte[]> pair: fileMap.entrySet()){

               // System.out.println(new File(pair.getKey().getName()).getAbsolutePath());



                zos.putNextEntry(pair.getKey());

                zos.write(pair.getValue());

                //is.close();
            }

            zos.close();
       // }
    }
}
