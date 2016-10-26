package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> lines1 = new ArrayList<>();
    public static List<String> lines2 = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader file1reader = new BufferedReader(new FileReader(file1));
        BufferedReader file2reader = new BufferedReader(new FileReader(file2));
        while (file1reader.ready()) {
            String str1 = file1reader.readLine();
            lines1.add(str1);
        }
        while (file2reader.ready()) {
            String str2 = file2reader.readLine();
            lines2.add(str2);
        }
        reader.close();
        file1reader.close();
        file2reader.close();
        int i1 = 0;
        int i2 = 0;
        while (i1 < lines1.size() && i2 < lines2.size()) {
            if (lines1.get(i1).equals(lines2.get(i2)))
            {
                lines.add(new LineItem(Type.SAME, lines1.get(i1)));
                i1++;
                i2++;
            }
            else if (lines1.get(i1).equals(lines2.get(i2+1)))
            {
                lines.add(new LineItem(Type.ADDED, lines2.get(i2)));
                i2++;
            }
            else if (lines1.get(i1+1).equals(lines2.get(i2)))
            {
                lines.add(new LineItem(Type.REMOVED, lines1.get(i1)));
                i1++;
            }
        }
        if (i1 < lines1.size())
            lines.add(new LineItem(Type.REMOVED, lines1.get(i1)));
        if (i2 < lines2.size())
            lines.add(new LineItem(Type.ADDED, lines2.get(i2)));
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type + " " + lines.get(i).line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
