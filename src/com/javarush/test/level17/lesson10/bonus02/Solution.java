package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        if(args[0].equals("-c"))
            addPeople(args);
        else if(args[0].equals("-u"))
            updPeople(args);
        else if(args[0].equals("-d"))
            delPeople(args);
        else if(args[0].equals("-i"))
            infPeople(args);
    }

    public static synchronized void addPeople(String[] args) throws ParseException
    {
        int i = 1;
        while(i < args.length)
        {
            if (args[i+1].equals("м"))
            {
                allPeople.add(Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2])));
                System.out.println(allPeople.size() - 1);
            } else if (args[i+1].equals("ж"))
            {
                allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2])));
                System.out.println(allPeople.size() - 1);
            } else
                System.out.println("Wrong sex format");
            i+=3;
        }
    }

    public static synchronized void updPeople(String[] args) throws ParseException
    {
        int i = 1;
        while(i < args.length) {
            if(Integer.parseInt(args[i]) >= 0 && Integer.parseInt(args[i]) < allPeople.size())
            {
                if (args[i+2].equals("м"))
                {
                    allPeople.get(Integer.valueOf(args[i])).setName(args[i+1]);
                    allPeople.get(Integer.valueOf(args[i])).setSex(Sex.MALE);
                    allPeople.get(Integer.valueOf(args[i])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]));

                } else if (args[3].equals("ж"))
                {
                    allPeople.get(Integer.valueOf(args[i])).setName(args[i+1]);
                    allPeople.get(Integer.valueOf(args[i])).setSex(Sex.FEMALE);
                    allPeople.get(Integer.valueOf(args[i])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]));

                } else
                    System.out.println("Wrong sex format");
            }
            else
                System.out.println("Wrong id");
            i+=4;
        }
    }

    public static synchronized void delPeople(String[] args) {
        int i = 1;
        while(i < args.length) {
            if(Integer.parseInt(args[i]) >= 0 && Integer.parseInt(args[i]) < allPeople.size())
            {
                allPeople.get(Integer.valueOf(args[i])).setName(null);
                allPeople.get(Integer.valueOf(args[i])).setSex(null);
                allPeople.get(Integer.valueOf(args[i])).setBirthDay(null);
                i++;
            }
            else
                System.out.println("Wrong id");
        }
    }

    public static synchronized void infPeople(String[] args) {
        int i = 1;
        while(i < args.length) {
            if(Integer.parseInt(args[i]) >= 0 && Integer.parseInt(args[i]) < allPeople.size())
            {
                Person pers = allPeople.get(Integer.valueOf(args[i]));
                String sex;
                if(pers.getSex() == Sex.MALE)
                    sex = "м";
                else
                    sex = "ж";
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(pers.getName()+" "+sex+" "+dateFormat.format(pers.getBirthDay()));
            }
            else
                System.out.println("Wrong id");
            i++;
        }
    }
}
