package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> filenames = new TreeMap<>();
        String filename = reader.readLine();
        String newfilename = filename.substring(0, filename.lastIndexOf("."));
        File newfile = new File(newfilename);
        FileOutputStream file = new FileOutputStream(newfile, true);
        String num;
        while (!filename.equals("end")) {
            num = filename.substring(filename.lastIndexOf("t")+1);
            filenames.put(Integer.valueOf(num), filename);
            filename = reader.readLine();
        }
        int i = 0;
        for(Map.Entry e : filenames.entrySet()) {
            FileInputStream file1 = new FileInputStream((String) e.getValue());
            byte[] buffer = new byte[file1.available()];
            while (file1.available() > 0) {
                file1.read(buffer);
                file.write(buffer);
            }
            file1.close();
        }
        file.close();
        reader.close();
    }
}
