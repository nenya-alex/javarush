package com.javarush.test.level22.lesson09.task02;


import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    static Map<String, String> map = new HashMap<>();

//    public static void main(String[] args)
//    {
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", "45");
//        System.out.println(getCondition(map).toString());
//    }
    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (Map.Entry<String, String> it: params.entrySet())
        {
            if (it.getValue() != null)
            {
                String s = it.getKey() +" = "+"'"+it.getValue()+"'";
                sb.append(str).append(s);

            }
            str = " and ";
        }
        return sb;
    }
}
