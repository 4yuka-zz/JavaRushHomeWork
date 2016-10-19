package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String filename) throws FileNotFoundException {
        this.stream = new FileOutputStream(filename);
        this.filename = filename;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.filename, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        String filename = "C:\\Java\\1.txt";
        Solution object = new Solution(filename);
        object.writeObject("123");
        object.close();
        //SAVE
        String filename1 = "C:\\Java\\2.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename1));
        outputStream.writeObject(object);
        outputStream.flush();
        outputStream.close();
        //LOAD
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename1));
        Solution object1 = (Solution) inputStream.readObject();
        inputStream.close();
        object1.writeObject("456");
        object1.close();

    }
}
