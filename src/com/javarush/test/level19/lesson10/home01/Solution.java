package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStreamReader insReader = new InputStreamReader(new FileInputStream(args[0]));
        BufferedReader file = new BufferedReader(insReader);
        Map<String, Double> map = new HashMap<>();
        while (file.ready()) {
            String s = file.readLine();
            String[] str = s.split(" ");
            if (map.containsKey(str[0])) {
                double i = map.get(str[0]);
                map.put(str[0], i + Double.valueOf(str[1]));
            }
            else
                map.put(str[0], Double.valueOf(str[1]));
        }
        Map<String, Double> sortedMap = new TreeMap<String, Double>(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(map);
        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        insReader.close();
        file.close();
    }
}
