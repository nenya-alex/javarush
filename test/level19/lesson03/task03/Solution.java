package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDataAdapter implements Customer, Contact
    {
        IncomeData id;

        IncomeDataAdapter(IncomeData id)
        {
            this.id = id;
        }


        @Override
        public String getName()
        {
            return id.getContactLastName()+", "+id.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String number = id.getPhoneNumber() + "";
            while (number.length() < 10) {
                number = "0" + number;
            }
            return "+" + id.getCountryPhoneCode() +
                    "(" + number.substring(0, 3) + ")" +
                    number.substring(3, 6) + "-" + number.substring(6, 8) +
                    "-" + number.substring(8);
        }

        @Override
        public String getCompanyName()
        {
            return id.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(id.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}