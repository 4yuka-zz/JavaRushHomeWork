package com.javarush.test.level09.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        int[] arr1 = new int[5];
        for (int i = 0; i < 5; i++)
        {
            arr1[i] = i;
        }
        int[] arr2 = new int[2];
        for (int i = 0; i < 2; i++)
        {
            arr2[i] = i;
        }
        int[] arr3 = new int[4];
        for (int i = 0; i < 4; i++)
        {
            arr3[i] = i;
        }
        int[] arr4 = new int[7];
        for (int i = 0; i < 7; i++)
        {
            arr4[i] = i;
        }
        int[] arr5 = new int[0];

        ArrayList<int[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        return list;

    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
