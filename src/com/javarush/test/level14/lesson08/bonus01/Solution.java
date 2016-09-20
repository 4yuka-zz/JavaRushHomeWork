package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] array = new int[-1];


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] array = new int[10];
            array[11] = 1;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            int s1 = Integer.valueOf(s);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            LinkedList list = new LinkedList();
            list.get(-1);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "wer";
            int i = Integer.parseInt(s);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            String s1 = s.concat(s);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "123";
            String s1 = s.substring(4);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream file = new FileInputStream("d:\\zxcvv.txt");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
