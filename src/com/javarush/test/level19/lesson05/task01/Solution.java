package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(reader1.readLine());
        FileWriter writer = new FileWriter(reader1.readLine());
        int i = 1;
        while (reader.ready())
        {
            int data = reader.read();
            if(i % 2 == 0)
                writer.write(data);
            i++;
        }

        reader.close();
        writer.close();
    }
}
