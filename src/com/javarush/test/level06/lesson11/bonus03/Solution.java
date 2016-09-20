package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int mas[] = new int[5];
        for(int i = 0; i<5; i++)
        {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        int min;
        int j = 0;
        while(j<4)
        {
            if(mas[j+1] < mas[j])
            {
                min = mas[j+1];
                mas[j+1] = mas[j];
                mas[j] = min;
                if(j!=0)
                    j--;
            }
            else
            {
                min = mas[j];
                j++;
            }
        }
        for(int i = 0; i<5; i++)
        {
            System.out.println(mas[i]);
        }
    }
}
