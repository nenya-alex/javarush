package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("123.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name, true);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Alex");
            user1.setLastName("N");
            user1.setBirthDate(new Date(2118965548));
            user1.setMale(true);
            User.Country country1 = User.Country.UKRAINE;
            user1.setCountry(country1);

            User user2 = new User();
            user2.setFirstName("Eva");
            user2.setLastName("Evil");
            user2.setBirthDate(new Date(1980022399));
            user2.setMale(false);
            User.Country country2 = User.Country.RUSSIA;
            user2.setCountry(country2);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            //javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println("Old user"+ javaRush.users);
            for (User it: javaRush.users)
            {
                System.out.println("firstName: "+it.getFirstName());
                System.out.println("lastName: "+it.getLastName());
                System.out.println("date: "+it.getBirthDate());
                System.out.println("sex: "+it.isMale());
                System.out.println("country: "+it.getCountry());
            }
            System.out.println("New user"+ loadedObject.users);
            for (User it: loadedObject.users)
            {
                System.out.println("firstName: "+it.getFirstName());
                System.out.println("lastName: "+it.getLastName());
                System.out.println("date: "+it.getBirthDate());
                System.out.println("sex: "+it.isMale());
                System.out.println("country: "+it.getCountry());
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User it: users)
            {
                writer.println(it.getFirstName());
                writer.println(it.getLastName());
                writer.println(it.getBirthDate().getTime());
                writer.println(it.isMale());
                writer.println(it.getCountry());
                writer.println("end");
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream));

            while (reader.ready())
            {
                User user = new User();
                String firstName;
                String lastName;
                boolean sex;
                User.Country country;
                while (!(firstName = reader.readLine()).equals("end"))
                {
                    //System.out.println("firstName: "+firstName);
                    user.setFirstName(firstName);

                    lastName = reader.readLine();
                    //System.out.println("lastName: "+lastName);
                    user.setLastName(lastName);

                    long l = Long.parseLong(reader.readLine());
                    //System.out.println("date: "+l);
                    user.setBirthDate(new Date(l));

                    sex = Boolean.parseBoolean(reader.readLine());
                    //System.out.println("sex: "+sex);
                    user.setMale(sex);

                    country = User.Country.valueOf(reader.readLine());
                    //System.out.println("country: "+country.getDisplayedName());
                    user.setCountry(country);
                }
                users.add(user);
            }
        }
    }
}
