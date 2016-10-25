package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(args[2]));
        int nextByte;
        List<Integer> bytes = new ArrayList<>();
        int i = 0;
        if(args[0].equals("-e")) {
            while ((nextByte = reader.read()) != -1) {
                bytes.add(nextByte + 1);
                i++;
            }
        }
        else {
            while ((nextByte = reader.read()) != -1) {
                bytes.add(nextByte - 1);
                i++;
            }
        }
        for(int j = 0; j < i; j++) {
            writer.write(bytes.get(j));
        }
        reader.close();
        writer.close();
    }

}
