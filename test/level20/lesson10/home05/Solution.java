package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

//    public static void main(String args[]) throws Exception {
//
//        try
//        {
//            FileOutputStream fileOutput = new FileOutputStream("123.txt");
//            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
//
//            Person person = new Person("Alex", "Non", "ukr", Sex.MALE);
//
//            System.out.println(person.firstName + " " + person.lastName + " " + person.country + " " + person.sex
//                    + " " + person.fullName + " " + person.greetingString + " " + person.logger + " " + person.outputStream);
//
//            //person.writeExternal(outputStream);
//            outputStream.writeObject(person);
//
//            fileOutput.flush();
//            fileOutput.close();
//            outputStream.close();
//
//            //loading
//            FileInputStream fiStream = new FileInputStream("123.txt");
//            ObjectInputStream objectStream = new ObjectInputStream(fiStream);
//
//            Person newPerson = (Person) objectStream.readObject();
//            System.out.println(newPerson.firstName + " " + newPerson.lastName + " " + newPerson.country + " " + newPerson.sex
//                    + " " + newPerson.fullName + " " + newPerson.greetingString + " " + newPerson.logger + " " + newPerson.outputStream);
//
//            fiStream.close();
//            objectStream.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }

    public static class Person implements Serializable
    {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString ;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;
        //private static final long serialVersionUID = 1L;

        public Person()
        {
            this.greetingString = "Hello, ";
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

//        private void writeObject(ObjectOutputStream out) throws IOException {
//            out.defaultWriteObject();
//            out.close();
//        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
            in.close();
        }


    }

    enum Sex {
        MALE,
        FEMALE
    }
}
