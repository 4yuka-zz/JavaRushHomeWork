package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {

            if(args[0].equals("-c"))
            {
                if(args[2].equals("м"))
                {
                    allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
                else if(args[2].equals("ж"))
                {
                    allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
                else
                    System.out.println("Wrong sex format");
            }
            else if(args[0].equals("-u"))
            {
                if(Integer.parseInt(args[1]) >= 0 && Integer.parseInt(args[1]) < allPeople.size())
                {
                    if (args[3].equals("м"))
                    {
                        allPeople.get(Integer.valueOf(args[1])).setName(args[2]);
                        allPeople.get(Integer.valueOf(args[1])).setSex(Sex.MALE);
                        allPeople.get(Integer.valueOf(args[1])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));

                    } else if (args[3].equals("ж"))
                    {
                        allPeople.get(Integer.valueOf(args[1])).setName(args[2]);
                        allPeople.get(Integer.valueOf(args[1])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.valueOf(args[1])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));

                    } else
                        System.out.println("Wrong sex format");
                }
                else
                    System.out.println("Wrong id");
            }
            else if(args[0].equals("-d"))
            {
                if(Integer.parseInt(args[1]) >= 0 && Integer.parseInt(args[1]) < allPeople.size())
                {
                    allPeople.get(Integer.valueOf(args[1])).setName(null);
                    allPeople.get(Integer.valueOf(args[1])).setSex(null);
                    allPeople.get(Integer.valueOf(args[1])).setBirthDay(null);
                    //allPeople.remove(Integer.parseInt(args[1]));
                }
                else
                    System.out.println("Wrong id");
            }
            else if(args[0].equals("-i"))
            {
                if(Integer.parseInt(args[1]) >= 0 && Integer.parseInt(args[1]) < allPeople.size())
                {
                    Person pers = allPeople.get(Integer.valueOf(args[1]));
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
            }
        }

    }

