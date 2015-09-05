package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("123.txt", null);
            File your_file_name = new File("123.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name, true);
            InputStream inputStream = new FileInputStream(your_file_name);

            Asset home = new Asset("home");
            home.setPrice(12000);
            Human ivanov = new Human("Ivanov", home, new Asset("car"), new Asset("car2"));
            Human ivanov2 = new Human("Ivanov2", home, new Asset("car88"), new Asset("car22"));
            Human ivanov3 = new Human("Ivanov3");
            Human ivanov4 = new Human(null);

//            ivanov.save(outputStream);
//            outputStream.flush();
//            ivanov2.save(outputStream);
//            outputStream.flush();
//            ivanov3.save(outputStream);
//            outputStream.flush();
//            ivanov4.save(outputStream);
//            outputStream.flush();


            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println("ivanov "+ivanov.name);
            for (Asset it:ivanov.assets)
            System.out.println(it.getName()+" "+it.getPrice());

            System.out.println("==============================");
            System.out.println("somePerson "+somePerson.name);
            for (Asset it:somePerson.assets)
                System.out.println(it.getName()+" "+it.getPrice());

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if (name!=null)
            {
                writer.println(name);
                String isAssets = assets.size()>0? "yes": "no";

                if (assets.size()>0)
                {
                    writer.println(isAssets);
                    for (int i=0; i< assets.size(); i++)
                    {
                        if (i!=assets.size()-1)
                        {
                            writer.println(assets.get(i).getName());
                            writer.println(Double.toString(assets.get(i).getPrice()));
                        }
                        else
                        {
                            writer.println(assets.get(i).getName());
                            writer.println(Double.toString(assets.get(i).getPrice()));
                            writer.println("end");
                        }
                    }
                }
                else
                {
                    writer.println(isAssets);
                    writer.println("end");
                }
                writer.close();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream));
            while (reader.ready())
            {
                //Human human = new Human();//надо для чтения больше чем одного человека
                //human.name = reader.readLine();
                this.name = reader.readLine();
                String isAssets = reader.readLine();

                if (isAssets.equals("yes"))
                {
                    Asset nameAsset;
                    String str;
                        while (!(str=reader.readLine()).equals("end"))
                        {
                            nameAsset = new Asset(str);
                            nameAsset.setPrice(Double.parseDouble(reader.readLine()));
                            //human.assets.add(nameAsset);
                            this.assets.add(nameAsset);
                        }

                }
                else if (isAssets.equals("no"))
                {
                    reader.readLine();
                }
//                System.out.println("somePerson "+human.name);
//                for (Asset it:human.assets)
//                    System.out.println(it.getName()+" "+it.getPrice());
            }
             reader.close();

        }
    }
}
