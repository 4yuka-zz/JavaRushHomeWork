package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("    k"));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int start = -1;
        int end = -1;
        int temp = 0;
        int temp1 = 0;
        for (int i = 0; temp1 >= 0; i++) {
            temp1 = string.substring(temp).indexOf(" ");
            if (temp1 == -1)
                temp = string.length() + 1;
            else
                temp = temp1 + temp + 1;
            if (i == 0)
                start = temp;
            if (i == 4)
                end = temp - 1;
        }
        if (start == -1 || end == -1)
            throw new TooShortStringException();
        return string.substring(start, end);
    }

    public static class TooShortStringException extends Exception{
    }
}
