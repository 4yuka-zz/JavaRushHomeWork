package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String num;
        List<Integer> list = new ArrayList<Integer>();
        while ((num = file.readLine()) != null)
        {
            Integer i = Integer.valueOf(num);
            if(i%2==0)
                list.add(i);

        }
        Collections.sort(list, Collections.<Integer>reverseOrder());
        for(int a: list)
            System.out.println(a);
    }
}
