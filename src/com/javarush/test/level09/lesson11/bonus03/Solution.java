package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        String s;
        int i = 0;
        while(i < array.length - 1)
        {
            if (isNumber(array[i]))
            {
                int i1 = i + 1;

                while (!isNumber(array[i1]) && i1 < array.length-1)
                    i1++;
                if (isNumber(array[i1]))
                {

                    if (Integer.parseInt(array[i1]) > Integer.parseInt(array[i]))
                    {
                        s = array[i1];
                        array[i1] = array[i];
                        array[i] = s;
                        if (i > 0)
                        {
                            i--;
                            while (!isNumber(array[i]) && i > 0)
                                i--;
                        }
                        else
                            i++;
                    } else
                        i++;
                } else
                    i++;

            }
            else
            {
                int i2 = i + 1;

                while (isNumber(array[i2]) && i2 < array.length-1)
                    i2++;
                if (!isNumber(array[i2]))
                {
                    if (isGreaterThan(array[i], array[i2]))
                    {
                        s = array[i2];
                        array[i2] = array[i];
                        array[i] = s;
                        if (i > 0)
                        {
                            i--;
                            while (isNumber(array[i]) && i > 0)
                                i--;
                        }
                        else
                            i++;
                    } else
                        i++;
                } else
                    i++;

            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
