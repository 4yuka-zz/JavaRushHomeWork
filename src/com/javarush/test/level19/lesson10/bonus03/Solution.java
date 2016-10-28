package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String html = "";
        while(filereader.ready()) {
            int data = filereader.read();
            html += (char)data;
        }
        html = html.replaceAll("\\s+"," ");
        html = html.replaceAll("<\\s+","<");
        html = html.replaceAll("</\\s+","</");
        html = html.replaceAll("\\s+>",">");
        reader.close();
        filereader.close();

        String tag11 = "<" + args[0] + " ";
        String tag12 = "<" + args[0] + ">";
        String tag2 = "</" + args[0] + ">";
        int i;
        int j = 0;
        int begin;
        int begin1 = html.indexOf(tag11);
        int begin2 = html.indexOf(tag12);
        if (begin1 == -1)
            begin = begin2;
        else if (begin2 == -1)
            begin = begin1;
        else if (begin1 < begin2)
            begin = begin1;
        else
            begin = begin2;
        if (begin != -1)
            i = begin + 1;
        else
            i = begin;
        while (i != -1) {
            int k = i + args[0].length() + 1;
            if (html.substring(i - 1, k).equals(tag11) || html.substring(i - 1, k).equals(tag12))
                j++;
            else if (html.substring(i - 2, k).equals(tag2))
                j--;
            if (j == 0) {
                System.out.println(html.substring(begin, i + args[0].length() + 1));
                begin1 = html.indexOf(tag11, begin + 1);
                begin2 = html.indexOf(tag12, begin + 1);
                if (begin1 == -1)
                    begin = begin2;
                else if (begin2 == -1)
                    begin = begin1;
                else if (begin1 < begin2)
                    begin = begin1;
                else
                    begin = begin2;
                if (begin != -1)
                    i = begin + 1;
                else
                    i = begin;
            }
            else
                i = html.indexOf(args[0], i + 1);
        }

    }
}
