package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        int id = maxID(filename) + 1;
        String ids = String.valueOf(id);
        char[] b = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        StringBuffer str = new StringBuffer(String.valueOf(b));
        str.insert(0, ids);
        str.insert(8, args[1]);
        str.insert(38, args[2]);
        str.insert(46, args[3]);
        String str1 = str.substring(0, 50);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        printWriter.println(str1);
        printWriter.close();
    }
    public static int maxID(String filename) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int max = 0;
        while(reader.ready()) {
            String str = reader.readLine().substring(0,8);
            str = str.replaceAll(" ", "");
            int id = Integer.valueOf(str);
            if(id > max) {
                max = id;
            }
        }
        reader.close();
        return max;
    }
}
