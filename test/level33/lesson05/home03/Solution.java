package com.javarush.test.level33.lesson05.home03;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.4.3

В метод convertFromJsonToNormal первым параметром приходит имя файла,
который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла,
преобразовать его из JSON и вернуть его.
*/
public class Solution {

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz)
            throws IOException
    {
        File file = new File(fileName);
        ObjectMapper om = new ObjectMapper();
        return om.readValue(file, clazz);
    }

//    public static void main(String[] args) throws IOException {
//        Cat cat = new Cat();
//        cat.name = "Murka";
//        cat.age = 5;
//        cat.weight = 3;
//
//        StringWriter writer = new StringWriter();
//        convertToJSON(writer, cat);
//        BufferedWriter br = new BufferedWriter(new FileWriter("1.txt"));
//        br.write(writer.toString());
//        br.close();
//        System.out.println(writer.toString());
//        Cat newCat = convertFromJsonToNormal("1.txt", Cat.class);
//        System.out.println(newCat.toString());
//    }
//
//    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(writer, object);
//    }
//
//    @JsonAutoDetect
//    public static class Cat {
//
//
//        public String name;
//
//
//        public int age;
//
//
//        public int weight;
//
//        Cat() {
//        }
//
//        @Override
//        public String toString() {
//            return "Cat{" +
//                    "name='" + name + '\'' +
//                    ", age=" + age +
//                    ", weight=" + weight +
//                    '}';
//        }
//    }
}
