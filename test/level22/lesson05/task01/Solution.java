package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {

//    public static void main(String[] args) throws TooShortStringException
//    {
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//    }

        public static String getPartOfString(String string) throws TooShortStringException
        {
            if (string == null)
                throw new TooShortStringException();
            String str = "";
            String tmp;
            int k = string.indexOf(" ");
                    int n = 0;
                    if (k < 0)
                    {
                        throw new TooShortStringException();
                    }
                    else
                    {
                        tmp = string.substring(k + 1);

                        for (int i = 0; i < 3; i++)
                        {
                            k = tmp.indexOf(" ");
                            if (k < 0)
                            {
                                //System.out.println("Ex");
                                throw new TooShortStringException();
                            }
                            str = str + tmp.substring(0, k + 1);
                            tmp = tmp.substring(k + 1);
                        }
                        k = tmp.indexOf(" ");
                        if (k > 0)
                        {
                            str = str + tmp.substring(0, k);
                        } else
                        {
                            str = str + tmp;
                        }
                    }
                return str;

        }


    public static class TooShortStringException extends Exception
    {

    }
}
