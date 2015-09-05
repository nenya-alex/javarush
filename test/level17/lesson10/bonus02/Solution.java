package com.javarush.test.level17.lesson10.bonus02;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/
//хорошая задача, решена с 1 попытки.
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        if (args.length%3==1&&args[0].equals("-c"))
        {
            Person person = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = null;
            String name = null;
            String sex = null;
            for (int i = 1; i < args.length; )
            {
                for (int j = 0; j < 3; j++)
                {
                    if (i%3==0)
                    {
                        date = sdf.parse(args[i]);
                    }
                    if (i%3==1)
                    {
                        name = args[i];
                    }
                    if (i%3==2)
                    {
                        sex=args[i];
                    }
                    i++;
                }
                if (sex.equals("м"))
                    person = Person.createMale(name, date);
                else if (sex.equals("ж"))
                    person = Person.createFemale(name, date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }

        }
        else if(args.length%4==1&&args[0].equals("-u")){
            Person person = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            for (int i = 1; i < args.length; )
            {
                for (int j = 0; j < 4; j++)
                {
                    if (i%4==1)
                        person = allPeople.get(Integer.parseInt(args[i]));
                    if (i%4==2)
                        person.setName(args[i]);
                    if (i%4==3)
                    {
                        if (args[i].equals("м"))
                            person.setSex(Sex.MALE);
                        else if (args[i].equals("ж"))
                            person.setSex(Sex.FEMALE);
                    }
                    if (i%4==0)
                    {
                        Date date = sdf.parse(args[i]);
                        person.setBirthDay(date);
                    }
                    i++;
                }
            }
        }
        else  if(args.length>1&&args[0].equals("-d")){
            for (int i = 1; i < args.length; i++)
            {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }

        }
        else  if(args.length>1&&args[0].equals("-i")){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            String sexFormat = "";
            for (int i = 1; i < args.length; i++)
            {
                Person person = allPeople.get(Integer.parseInt(args[i]));
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
}
