package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(short f)
    {
    }
    Solution(int a, String s)
    {
    }
    Solution(String s, double d)
    {
    }
    public Solution()
    {
    }
    public Solution(int a)
    {
    }
    public Solution(String s)
    {
    }
    private Solution(byte a)
    {
    }
    private Solution(int a, int b)
    {
    }
    private Solution(String s, int a)
    {
    }
    protected Solution(Object o)
    {
    }
    protected Solution(long a)
    {
    }
    protected Solution(String s, String f)
    {
    }
}

