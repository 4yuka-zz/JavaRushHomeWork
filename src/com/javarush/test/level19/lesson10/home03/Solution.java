package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        InputStreamReader insReader = new InputStreamReader(new FileInputStream(args[0]));
        BufferedReader file = new BufferedReader(insReader);
        while (file.ready()) {
            String s = file.readLine();
            String[] str = s.split(" ");
            String name = "";
            int num;
            int[] date = new int[3];
            int j = 0;
            for (int i = 0; i < str.length; i++)
            {
                try
                {
                    num = Integer.valueOf(str[i]);
                    date[j] += num;
                    j++;
                } catch (Exception e) {
                    name += str[i] + " ";
                }
            }
            Calendar cal = new GregorianCalendar(date[2], date[1]-1, date[0]);
            PEOPLE.add(new Person(name.substring(0, name.length()-1), new Date(cal.getTimeInMillis())));
        }
        for (Person e : PEOPLE) {
            System.out.println(e.getName() + " " + e.getBirthday());
        }
        insReader.close();
        file.close();
    }

}
