package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());
        int b = Integer.valueOf(reader.readLine());
        int max = a;
        int min = b;
        if(a>b)
        {
            max = a;
            min = b;
        }
        else
        {
            max = b;
            min = a;
        }
            int i = min;
            while(true)
            {
                if (max%i == 0 && min%i == 0)
                {
                    System.out.println(i);
                    break;
                }
                i--;
            }

    }
}
