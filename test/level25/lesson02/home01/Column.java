package com.javarush.test.level25.lesson02.home01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable
{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }

        }
        //System.out.println(Arrays.toString(realOrder));
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (int i = 0; i < realOrder.length; i++)
        {
            if (realOrder[i]!=-1)
            {
                result.add(Column.AccountNumber);
            }
        }
        //System.out.println(result);
        Column[] mas = values();
        //System.out.println(Arrays.toString(mas));
        for (int i = 0; i < realOrder.length; i++)
        {
            if (realOrder[i]!=-1)
            {

                    result.set(realOrder[i], mas[i]);

            }

        }
        return result;
    }

    @Override
    public String getColumnName()
    {
        return columnName;
    }

    @Override
    public boolean isShown()
    {
        Column[] mas = values();
        for (int i = 0; i < mas.length; i++)
        {
            if (this == mas[i] && realOrder[i]>-1)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void hide()
    {
        Column[] mas = values();
        int  k = -1;
        for (int i = 0; i < mas.length; i++)
        {
            if (this == mas[i]&& realOrder[i]!=-1)
            {
                k = realOrder[i];
                realOrder[i]=-1;
                for (int j = 0; j < realOrder.length; j++)
                {
                    if (realOrder[j]>k)
                    {
                        realOrder[j]--;
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(realOrder));
    }

//    @Override
//    public int ordinal()
//    {
//
//        return 0;
//    }
}
