package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String s = "";
        if(args[0].equals("-u")) {
            while (filereader.ready()) {
                String str = filereader.readLine();
                String id = str.substring(0,8);
                id = id.replaceAll(" ", "");
                if (args[1].equals(id)) {
                    char[] b = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
                    StringBuffer str1 = new StringBuffer(String.valueOf(b));
                    str1.insert(0, id);
                    str1.insert(8, args[2]);
                    str1.insert(38, args[3]);
                    str1.insert(46, args[4]);
                    String str2 = str1.substring(0, 50);
                    s = s + str2 + "\r\n";
                }
                else {
                    s = s + str + "\r\n";
                }
            }
        }
        else if (args[0].equals("-d")) {
            while (filereader.ready()) {
                String str = filereader.readLine();
                String id = str.substring(0,8);
                id = id.replaceAll(" ", "");
                if (!args[1].equals(id)) {
                    s = s + str + "\r\n";
                }
            }
        }
        filereader.close();
        PrintWriter printWriterdel = new PrintWriter(filename);
        printWriterdel.close();
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        printWriter.write(s);
        printWriter.close();
    }
}
