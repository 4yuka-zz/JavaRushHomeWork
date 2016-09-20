package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(filename1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(filename2));
        String line = file1.readLine();
        String[] words = line.split(" ");
        int size = words.length;
        for (int i = 0; i < size; i++)
        {
            double num = Double.valueOf(words[i]);
            String str = Integer.toString((int)Math.round(num));
            file2.write(str);
            file2.write(32);
        }
        reader.close();
        file1.close();
        file2.close();
    }
}
