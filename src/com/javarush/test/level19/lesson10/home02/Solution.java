package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStreamReader insReader = new InputStreamReader(new FileInputStream(args[0]));
        BufferedReader file = new BufferedReader(insReader);
        Map<String, Double> map = new HashMap<>();
        double i = 0;
        while (file.ready()) {
            String s = file.readLine();
            String[] str = s.split(" ");
            if (map.containsKey(str[0]))
                i = map.get(str[0]) + Double.valueOf(str[1]);
            else
                i = Double.valueOf(str[1]);
            map.put(str[0], i);
        }
        Double max = Double.MIN_VALUE;
        Double value;
        for (String s : map.keySet()) {
            value = map.get(s);
            if (value > max) {
                max = value;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (Double.compare((Double) entry.getValue(), max) == 0)
                System.out.println(entry.getKey());
        }
        insReader.close();
        file.close();
    }
}
