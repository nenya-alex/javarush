package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution implements Cloneable{

    public Solution()
    {
    }
    public Solution(Solution solution)
    {

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        Solution clone = (Solution) super.clone();

        Map<String, User> users = new LinkedHashMap(this.users.size());

        for (Map.Entry it: this.users.entrySet())
        {
            String str = (String) it.getKey();
            User user = (User) it.getValue();
            users.put(new String(str), new User(user.age, user.name));
        }
        clone.users = users;
        //System.out.println(users);
        return clone;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User {
        int age;
        String name;

//        public int getAge()
//        {
//            return age;
//        }
//
//        public void setAge(int age)
//        {
//            this.age = age;
//        }
//
//        public String getName()
//        {
//            return name;
//        }
//
//        public void setName(String name)
//        {
//            this.name = name;
//        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
//        public User() {
//        }
    }
}
