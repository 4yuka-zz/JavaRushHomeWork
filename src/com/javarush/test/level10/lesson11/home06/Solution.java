package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private String address;
        private String sex;
        private int age;
        private int height;
        private int weight;

        public Human(){}
        public Human(String name){
            this.name = name;
        }
        public Human(String name, String address){
            this.name = name;
            this.address = address;
        }
        public Human(String name, String address, String sex){
            this.name = name;
            this.address = address;
            this.sex = sex;
        }
        public Human(String name, String address, String sex, int age){
            this.name = name;
            this.address = address;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, String address, String sex, int age, int height){
            this.name = name;
            this.address = address;
            this.sex = sex;
            this.age = age;
            this.height = height;
        }
        public Human(String name, String address, String sex, int age, int height, int weight){
            this.name = name;
            this.address = address;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, String sex, int age, int height, int weight){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, String sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }
}
