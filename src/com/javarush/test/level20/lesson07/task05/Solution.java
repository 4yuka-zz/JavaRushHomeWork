package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
    {
        File your_file_name = File.createTempFile("your_file_name", null);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(your_file_name));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(your_file_name));
        Solution savedObject = new Solution(1);
        outputStream.writeObject(savedObject);
        System.out.println(savedObject);
        Solution loadedObject = (Solution)inputStream.readObject();
        System.out.println(loadedObject);
        inputStream.close();
        outputStream.close();
    }

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        try
        {
            while(speed < 10)
            {
                Thread.sleep(500);
                System.out.println(speed);
                speed++;
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }
}
