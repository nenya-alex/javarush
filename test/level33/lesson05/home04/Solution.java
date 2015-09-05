package com.javarush.test.level33.lesson05.home04;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/* Конвертация из одного класса в другой используя JSON
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.4.3

Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
Реализовать логику метода convertOneToAnother,
который должен возвращать объект класса resultClassObject,
значения полей которого равны значениям полей в объекте one.
Известно, что у классов есть Json аннотация,
у которой значение проперти равно имени класса в нижнем регистре.
На примере класса First, это className="first"
Классы First и Second не участвуют в тестировании,
они предоставлены в качестве тестовых данных.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
        //System.out.println(f);

//        Second s = new Second();
//        s.i = 1;
//        s.name = "sec";
//
//        System.out.println(s.toString());
//        //Second s = (Second) convertOneToAnother(new First(), Second.class);
//        First f = (First) convertOneToAnother(s, First.class);
//
//        System.out.println(f.toString());
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper().configure(MapperFeature.USE_ANNOTATIONS, false);

        StringWriter writer = new StringWriter();

        mapper.writeValue(writer, one);

        String jsonString = writer.toString();

        StringReader reader = new StringReader(jsonString);



        return mapper.readValue(reader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "First{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;

        @Override
        public String toString() {
            return "Second{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
