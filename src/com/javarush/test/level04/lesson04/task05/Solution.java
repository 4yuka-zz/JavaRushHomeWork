package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
  //      try {
            Integer i = new Integer(a);
            if(i>=0)
                i = i * 2;
            else
                i++;
            System.out.println(i);
   //     }catch (NumberFormatException e) {
    //        System.err.println("Неверный формат строки!");
    //    }

    }

}