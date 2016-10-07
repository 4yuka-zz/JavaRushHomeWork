package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader filereader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(args[1]));
        String[] s;
        String str = "";
        while(filereader.ready()) {
            s = filereader.readLine().split(" ");
            for(int i = 0; i < s.length; i++) {
                if(s[i].length() > 6)
                    str += s[i]+",";
            }
        }
        if(str.length() > 0)
            filewriter.write(str.substring(0, str.length()-1));
        filereader.close();
        filewriter.close();
    }
}
