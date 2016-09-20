package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("ded1", "мужской", 70, null, null);
        Human ded2 = new Human("ded2", "мужской", 65, null, null);
        Human baba1 = new Human("baba1", "женский", 65, null, null);
        Human baba2 = new Human("baba2", "женский", 60, null, null);
        Human otec = new Human("otec", "мужской", 40, ded1, baba1);
        Human mat = new Human("mat", "женский", 35, ded2, baba2);
        Human dite1 = new Human("dite1", "мужской", 15, otec, mat);
        Human dite2 = new Human("dite2", "мужской", 10, otec, mat);
        Human dite3 = new Human("dite3", "мужской", 5, otec, mat);
        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba1.toString());
        System.out.println(baba2.toString());
        System.out.println(otec.toString());
        System.out.println(mat.toString());
        System.out.println(dite1.toString());
        System.out.println(dite2.toString());
        System.out.println(dite3.toString());
    }

    public static class Human
    {
        private String name;
        private String sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, String sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + this.sex;
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
