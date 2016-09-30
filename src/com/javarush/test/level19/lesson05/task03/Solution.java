package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<>();
        int[] cats = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(reader1.readLine());
        FileWriter writer = new FileWriter(reader1.readLine());
        while (reader.ready())
        {
            boolean exit = false;
            int data = reader.read();
            if(data == 32 || data == 10 || data == 13)
            {
                int j = 0;
                while (j < list.size()) {
                    exit = false;
                    for (int  i = 0; i < 10; i++) {
                        if (cats[i] == list.get(j)) {
                            exit = true;
                            break;
                        }
                    }
                    if (exit == false)
                        break;
                    j++;
                }
                if (exit == true) {
                    int k = 0;
                    while (k < list.size()) {
                        writer.write(list.get(k));
                        k++;
                    }
                    writer.write(32);
                }
                list.clear();
            }
            else
                list.add(data);
        }
        reader1.close();
        reader.close();
        writer.close();
    }
}
