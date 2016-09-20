package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> key = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();
        s = s.substring(s.indexOf('?')+1);
        while (true)
        {
            int i = s.indexOf('&');
            int j = s.indexOf('=');
            if(i != -1)
            {
                if(j != -1 && i > j)
                {
                    key.add(s.substring(0,j));
                    if(s.substring(0,j).equals("obj"))
                        value.add(s.substring(j+1,i));
                }
                else
                    key.add(s.substring(0,i));
            }
            else
            {
                if(j != -1)
                {
                    key.add(s.substring(0,j));
                    if(s.substring(0,j).equals("obj"))
                        value.add(s.substring(j+1));
                }
                else
                    key.add(s);
                break;
            }
            s = s.substring(i+1);
        }
        for (String q : key)
        {
            System.out.print(q + " ");
        }
        System.out.println();

        for (String q : value)
        {
            try{
                double d = Double.parseDouble(q);
                alert(d);
            } catch (Exception e)
            {
                alert(q);
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
