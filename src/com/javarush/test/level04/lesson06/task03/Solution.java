package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        if(a>b)
            if(b>c)
                System.out.println(a+" "+b+" "+c);
            else
                if(a>c)
                    System.out.println(a+" "+c+" "+b);
                else
                    System.out.println(c+" "+a+" "+b);
        else
            if(a>c)
                System.out.println(b+" "+a+" "+c);
            else
                if(b>c)
                    System.out.println(b+" "+c+" "+a);
                else
                    System.out.println(c+" "+b+" "+a);




    }
}
