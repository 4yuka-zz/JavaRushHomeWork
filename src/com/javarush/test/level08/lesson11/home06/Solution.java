package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children0 = new ArrayList<Human>();
        Human child1 = new Human("child1", false, 15, children0);
        Human child2 = new Human("child2", true, 12, children0);
        Human child3 = new Human("child3", false, 11, children0);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human("father", true, 35, children);
        Human mother = new Human("mother", false, 33, children);
        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(father);
        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(mother);
        Human ded1 = new Human("ded1", true, 55, children1);
        Human baba1 = new Human("baba1", false, 53, children1);
        Human ded2 = new Human("ded2", true, 55, children2);
        Human baba2 = new Human("baba2", false, 53, children2);
        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
