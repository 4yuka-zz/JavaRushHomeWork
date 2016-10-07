package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader filereader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(args[1]));
        String[] s;
        while(filereader.ready()) {
            s = filereader.readLine().split(" ");
            for(int i = 0; i < s.length; i++) {
                if(s[i].matches(".*[0-9].*"))
                    filewriter.write(s[i]+" ");
            }
        }
        filereader.close();
        filewriter.close();
    }
}
