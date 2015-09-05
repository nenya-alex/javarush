package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/
/* БЫЛО
public class Solution {
    //1
    static {
        System.out.println("Static block");
    }

    {
    //4
        System.out.println("non-static block");
    //5
        printAllFields(this);
    }
    //7.3.1
    public int i = 6;
    //7.2.1
    public String name = "First name";
    //2
    static {
        init();
    }

    public Solution() {
    //6
        System.out.println("Solution constructor");
    //7
        printAllFields(this);
    }
    //2.1
    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
     //3
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
     //5.1
     //7.1
        System.out.println("static void printAllFields");
     //5.2
     //7.2
        System.out.println(obj.name);
     //5.3
     //7.3
        System.out.println(obj.i);
    }
}
*/
/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/
public class Solution {
    static {
        init();
    }
    //1
    static {
        System.out.println("Static block");
    }

    {
        //4
        System.out.println("non-static block");
        //5
        printAllFields(this);
    }
    //7.3.1
    public int i = 6;
    //7.2.1
    public String name = "First name";
    //2


    public Solution() {
        //6
        System.out.println("Solution constructor");
        //7
        printAllFields(this);
    }
    //2.1
    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        //3
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        //5.1
        //7.1
        System.out.println("static void printAllFields");
        //5.2
        //7.2
        System.out.println(obj.i);
        //5.3
        //7.3

        System.out.println(obj.name);
    }
}