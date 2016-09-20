package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int k1 = 0;
        int k2 = 0;
        if(a>0)
            k1++;
        if(b>0)
            k1++;
        if(c>0)
            k1++;
        if(a<0)
            k2++;
        if(b<0)
            k2++;
        if(c<0)
            k2++;
        System.out.println("количество отрицательных чисел: "+k2);
        System.out.println("количество положительных чисел: "+k1);

    }
}
