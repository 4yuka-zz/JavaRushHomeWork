package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream in = new FileInputStream(filename);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        while (in.available() > 0) {
            int data = in.read();
            list.add(data);
        }
        for (int key : list) {
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                map.put(key, value);
            }
            else {
                map.put(key, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            int value = pair.getValue();
            if (value > max) {
                max = value;
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == max) {
                System.out.print(key + " ");
            }
        }
        in.close();
    }
}
