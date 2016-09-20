package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        try {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

            if(a == b && a != c)
                System.out.print(3);
            if(b == c && b != a)
                System.out.print(1);
            if(a == c && a != b)
                System.out.print(2);

        }
        catch (Exception e)
        {
            System.err.println("введите число");
        }
    }
}
