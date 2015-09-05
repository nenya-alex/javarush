package com.javarush.test.level35.lesson10.bonus01;

//import com.javarush.test.level35.lesson10.bonus01.data.Cat;
//import com.javarush.test.level35.lesson10.bonus01.data.Cat1;
//import com.javarush.test.level35.lesson10.bonus01.data.Cat2;
//import com.javarush.test.level35.lesson10.bonus01.data.Cat3;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
        Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся
        скомпилированные классы.
        Путь не обязательно содержит / в конце.
        НЕ все классы наследуются от интерфейса Animal.
        НЕ все классы имеют публичный конструктор без параметров.
        Только для классов, которые наследуются от Animal
        и имеют публичный конструктор без параметров, - создать по одному объекту.
        Добавить созданные объекты в результирующий сет и вернуть.
        Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
//        SortedMap<String, Charset> charsets = Charset.availableCharsets();
//        System.out.println(charsets.size());
 //       Cat cat = new Cat();
//        Cat1 cat1 = new Cat1();
//        Cat2 cat2 = new Cat2(2);
//        Cat3 cat3 = new Cat3();

        Set<? extends Animal> allAnimals = getAllAnimals("E:\\Мои документы\\Саша\\" +
                "Java\\JavaRush8.10.14\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork" +
                "\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data");
        //Set<? extends Animal> allAnimals = getAllAnimals(null);
        System.out.println(allAnimals);
        for (Animal s: allAnimals)
        {
            System.out.println(s.getClass().getName());
        }
    }
    public static Set<? extends Animal> getAllAnimals(String pathToAnimals)
    {
        Set<Animal> result = new HashSet<>();
        if (pathToAnimals != null) {
            if (!pathToAnimals.endsWith("\\"))
            {
                if(!pathToAnimals.endsWith("/"))
                pathToAnimals = pathToAnimals + "/";
            }
            //System.out.println(pathToAnimals);
            File dir = new File(pathToAnimals);

            String[] modules = dir.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });
            //System.out.println(Arrays.toString(modules));
            if (modules.length == 0)
            {
                return result;
            }
            try {
                for (String m : modules) {
                    try {
                        final String finalPathToAnimals = pathToAnimals;

                        ClassLoader loader = new ClassLoader() {
                            @Override
                            public Class<?> findClass(String className) throws ClassNotFoundException {
                                try {

                                    byte b[] = fetchClassFromFS(finalPathToAnimals + className + ".class");
                                    return defineClass(null, b, 0, b.length);

                                }
                                catch (FileNotFoundException ex) {
                                    return super.findClass(className);
                                }
                                catch (IOException ex) {
                                    return super.findClass(className);
                                }

                            }
                        };
                        String mName = m.substring(0, m.length() - 6);
                        Class clazz = loader.loadClass(mName);

                        boolean hasInterface = false;

                        Class[] interfaces = clazz.getInterfaces();
                        //if (interfaces.length==1) {
                            for (Class i : interfaces) {
                                if (Animal.class == i) {
                                    hasInterface = true;
                                    break;
                                }
                            }
                        //}
                        if (!hasInterface) continue;

                        boolean hasConstructor = false;
                        Constructor[] constructors = clazz.getConstructors();

                        //System.out.println(clazz.getName());
                        //System.out.println(Arrays.toString(constructors));

                        for (Constructor c : constructors) {
                            //System.out.println(Arrays.toString(c.getParameterTypes()));
                            if (c.getModifiers()==1 && c.getParameterTypes().length == 0) {
                                hasConstructor = true;
                                break;
                            }
                        }
                        if (!hasConstructor) continue;
                        result.add((Animal) clazz.newInstance());
                    } catch (ClassNotFoundException e) {
                    } catch (InstantiationException e) {
                    } catch (IllegalAccessException e) {
                    } catch (ClassFormatError e) {
                    } catch (ClassCastException e) {
                    }
                }
            }
            catch (Exception e)
            {
                return result;
            }
            return result;
        }
        return result;
    }

    public static byte[] fetchClassFromFS(String path) throws IOException
    {

        InputStream is = new FileInputStream(path);

        byte[] bytes = new byte[is.available()];
        is.read(bytes);

        is.close();
        return bytes;
    }

}
