package com.javarush.test.level08.lesson06.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Измерить сколько времени занимает 10 тысяч вызовов get для каждого списка
Измерить, сколько времени занимает 10 тысяч вызовов get для каждого списка.
Метод getTimeMsOfGet  должен вернуть время его исполнения в миллисекундах.
*/

public class Solution
{
    public static void main(String[] args)
    {
        List array = fill(new ArrayList());
        List link = fill(new LinkedList());
        System.out.println(getTimeMsOfGet(array));
        System.out.println(getTimeMsOfGet(link));
    }

    private static List fill(List list)
    {
        for(int i = 0; i < 10000; i++)
        {
            list.add(new Object());
        }
        return list;
    }

    public static long  getTimeMsOfGet(List list)
    {
        Date start = new Date();

        get10000(list);

        Date stop = new Date();
        long delay = stop.getTime() - start.getTime();
        return delay;

    }

    public static void get10000(List list)
    {

        for (int i = 0; i < 10000; i++)
        {
            list.get(i);
        }
    }
}
