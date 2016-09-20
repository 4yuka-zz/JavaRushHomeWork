package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream in = new FileInputStream(filename);
        List<Integer> list = new ArrayList<>();
        while (in.available() > 0) {
            int data = in.read();
            boolean repeat = false;
            for (int elem : list) {
                if (data == elem)
                    repeat = true;
            }
            if (!repeat)
                list.add(data);
        }
        Collections.sort(list);
        for (int elem : list)
            System.out.print(elem + " ");
        in.close();
    }
}
