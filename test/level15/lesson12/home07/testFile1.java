package com.javarush.test.level15.lesson12.home07;

/**
 * Created by Alex on 17.11.2014.
 */
import java.io.*;
public class testFile1
{
    // Чтение (указанного пользователем) файла
// Построчное чтение и вывод на консоль его содержимого
// Перезапись файла



        public static void main(String[] args)
        {
            String sFileName=""; // Строка для имени файла
            System.out.println("\nFILE TEST\n");
            String stroka="\n";

            try
            {
                // OutputStreamWriter позволяет явно указать кодировку

                System.out.println("\nВведите имя файла:");


                BufferedReader     BR = new BufferedReader(new InputStreamReader(System.in));

                // ПОСТРОЧНЫЙ ВВОД (ИМЕНИ ФАЙЛА)
                sFileName = BR.readLine(); // читаем строку (имя файла)
                System.out.println("\nИщем файл "+sFileName);
                try
                {
                    FileInputStream in = new FileInputStream(sFileName);
                    System.out.println("\nФайл "+sFileName+" найден.\n");
                    System.out.println("\nСодержимое файла "+sFileName+":\n");

                    // Построчно читаем файл и печатаем его содержимое

                    BufferedReader BRf = new BufferedReader(new FileReader(sFileName));
                    do
                    {
                        stroka=BRf.readLine();
                        if(stroka!=null) {System.out.println(stroka);}
                    }
                    while(stroka!=null);

                    // Печатаем в файл нашу строку 3 раза
                    FileWriter FW = new FileWriter(sFileName);
                    BufferedWriter BWf = new BufferedWriter(FW);
                    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
                    BWf.newLine(); // переходим на новую строку
                    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
                    BWf.newLine(); // переходим на новую строку
                    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
                    BWf.close();// не забудем закрыть файл

                    System.out.println("\n\nФАЙЛ "+sFileName+" ПЕРЕЗАПИСАН.\n\n\n");


                }//try
                catch (FileNotFoundException e)
                {
                    System.out.println("Файл "+sFileName+" не найден.");
                }//catch (FileNotFoundException e) //catch
            }//try
            catch(Exception e)
            {
                System.out.println("Something is wrong....");
            }//catch(Exception e)
        }//main
    //testFile1
}
