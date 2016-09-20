package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

            int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
                String s = reader.readLine();
                if(s.equals("сумма"))
                    break;
                int n = Integer.parseInt(s);
                sum=sum+n;
            }
            System.out.print(sum);

    }
}
