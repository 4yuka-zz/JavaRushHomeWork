package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> array = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        int monthNum = 0;
        switch (month) {
            case "January": monthNum = 1;
                break;
            case "February": monthNum = 2;
                break;
            case "March": monthNum = 3;
                break;
            case "April": monthNum = 4;
                break;
            case "May": monthNum = 5;
                break;
            case "June": monthNum = 6;
                break;
            case "July": monthNum = 7;
                break;
            case "August": monthNum = 8;
                break;
            case "September": monthNum = 9;
                break;
            case "October": monthNum = 10;
                break;
            case "November": monthNum = 11;
                break;
            case "December": monthNum = 12;
                break;
            default: System.out.println("Invalid month");
                break;
        }
        System.out.println(month+" is "+monthNum+" month");
    }

}
