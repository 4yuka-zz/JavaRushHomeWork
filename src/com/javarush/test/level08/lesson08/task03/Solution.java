package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("nar0","much");
        map.put("nar1","much");
        map.put("nar2","much3");
        map.put("nar3","much2");
        map.put("nar4","much1");
        map.put("nar5","much");
        map.put("nar6","much");
        map.put("nar7","much1");
        map.put("nar8","much2");
        map.put("nar9","much");

        return (HashMap<String, String>) map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (String tmp : map.values())
        {
            if(name.equals(tmp))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        return map.containsKey(lastName) ? 1 : 0;

    }
}
