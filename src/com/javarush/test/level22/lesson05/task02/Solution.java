package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int start = -1;
        int end = -1;
        int temp = 0;
        int temp1 = 0;
        for (int i = 0; temp1 >= 0 && i < 2; i++) {
            temp1 = string.substring(temp).indexOf("\t");
            if (temp1 == -1)
                break;
            else
                temp = temp1 + temp + 1;
            if (i == 0)
                start = temp;
            if (i == 1)
                end = temp - 1;
        }
        if (start == -1 || end == -1)
            throw new TooShortStringException();
        return string.substring(start, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
