package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        File your_file_name = File.createTempFile("your_file_name", null);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(your_file_name));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(your_file_name));
        A savedObject = new A("1");
        outputStream.writeObject(savedObject);
        System.out.println(savedObject);
        A loadedObject = new A("2");
        System.out.println(loadedObject);
        inputStream.close();
        outputStream.close();
    }

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        protected String name;

        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}
