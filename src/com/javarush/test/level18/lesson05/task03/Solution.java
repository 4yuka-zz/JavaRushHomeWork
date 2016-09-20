package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        int k;
        int len = inputStream.available();
        if (len % 2 == 0)
            k = len / 2;
        else
            k = len / 2 + 1;
        byte[] buffer = new byte[len];
        inputStream.read(buffer);
        outputStream1.write(buffer, 0, k);
        outputStream2.write(buffer, k, len - k);
        reader.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
