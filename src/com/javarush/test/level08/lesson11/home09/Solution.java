package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();
        System.out.println(isDateOdd(date));
    }

    public static boolean isDateOdd(String date)
    {
        int mon = 0;
        String month = date.substring(0, 3);
        switch (month) {
            case "JAN": mon = 0;
                break;
            case "FEB": mon = 1;
                break;
            case "MAR": mon = 2;
                break;
            case "APR": mon = 3;
                break;
            case "MAY": mon = 4;
                break;
            case "JUN": mon = 5;
                break;
            case "JUL": mon = 6;
                break;
            case "AUG": mon = 7;
                break;
            case "SEP": mon = 8;
                break;
            case "OCT": mon = 9;
                break;
            case "NOV": mon = 10;
                break;
            case "DEC": mon = 11;
                break;
            default: System.out.println("Invalid month");
                break;
        }
        int number = Integer.parseInt(date.substring(date.indexOf(" ")+1, date.lastIndexOf(" ")));
        int year = Integer.parseInt(date.substring(date.lastIndexOf(" ")+1));
        Date date1 = new Date(year-1900, mon, number);
        Date date2 = new Date(year-1900, 0,0);
        long msDiff = date1.getTime() - date2.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msDiff/msDay);

        return (dayCount % 2 != 0) ? true : false;
    }
}
