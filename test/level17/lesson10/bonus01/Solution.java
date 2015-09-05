package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/
//задача хорошая, но поначалу не понятно чего вообще от нас хотят!!! ничего не сказано об имени человека,
// 1 или 2 слова в имени?
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
//        if (args.length < 2)
//            return;
        if (args.length==4&&args[0].equals("-c"))
        {
            Person person = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            Date date = sdf.parse(args[3]);
            if (args[2].equals("м"))
                person  = Person.createMale(args[1], date);
            else if (args[2].equals("ж"))
                person  = Person.createFemale(args[1], date);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        else if(args.length==5&&args[0].equals("-u")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            if (args[3].equals("м"))
                person.setSex(Sex.MALE);
            else if (args[3].equals("ж"))
                person.setSex(Sex.FEMALE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            Date date = sdf.parse(args[4]);
            person.setBirthDay(date);
            // allPeople.set(Integer.parseInt(args[1]), person);
        }
        else  if(args.length==2&&args[0].equals("-d")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);

        }


        else  if(args.length==2&&args[0].equals("-i")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

            String sexFormat = "";
            if (person.getSex().equals(Sex.MALE)) {
                sexFormat = "м";
            }
            if (person.getSex().equals(Sex.FEMALE)){
                sexFormat = "ж";
            }

            System.out.println(person.getName() + " " + sexFormat + " " + sdf.format(person.getBirthDay()));
        }
    }
}