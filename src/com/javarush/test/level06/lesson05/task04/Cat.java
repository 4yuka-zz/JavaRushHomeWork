package com.javarush.test.level06.lesson05.task04;

/* Cчётчик котов
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 1. В методе finalize уменьшать на 1.
*/

public class Cat
{
    public static int catCount = 0;

    public Cat() {
        catCount++;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println(cat1.catCount);
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        System.out.println(cat3.catCount);
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        System.out.println(cat4.catCount);

    }

    protected void finalize() throws Throwable
    {
        catCount--;
    }
}
