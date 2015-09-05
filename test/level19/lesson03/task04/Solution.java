package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner
    {
        Scanner scan;
        public  PersonScannerAdapter (Scanner scanner)
        {
            this.scan = scanner;
        }
        @Override
        public Person read() throws IOException, ParseException
        {

            String[] temp = new String[6];
            for (int i = 0; i < 6; i++)
            {
                temp[i] = scan.next();
            }

            String firstName = temp[1];
            String middleName = temp[2];
            String lastName = temp[0];

            Calendar calendar = new GregorianCalendar(Integer.parseInt(temp[5]), Integer.parseInt(temp[4]) - 1, Integer.parseInt(temp[3]));
            Date birthDate = calendar.getTime();
            Person user = new Person(firstName, middleName, lastName, birthDate);

            return user;
        }

        @Override
        public void close() throws IOException
        {
            scan.close();
        }
    }
}
