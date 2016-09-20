package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        RandomAccessFile file = new RandomAccessFile(filename1, "rw");
        FileInputStream file1 = new FileInputStream(filename1);
        FileInputStream file2 = new FileInputStream(filename2);

        byte[] buffer1 = new byte[file1.available()];
        int count1 = file1.read(buffer1);

        byte[] buffer2 = new byte[file2.available()];
        int count2 = file2.read(buffer2);

        file.write(buffer2, 0, count2);
        file.write(buffer1, 0, count1);

        reader.close();
        file.close();
        file1.close();
        file2.close();
    }
}
