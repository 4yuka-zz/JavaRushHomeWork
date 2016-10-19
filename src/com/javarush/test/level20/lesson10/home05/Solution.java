package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        File your_file_name = File.createTempFile("your_file_name", null);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(your_file_name));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(your_file_name));
        Person save = new Person("1", "2", "RU", Sex.MALE);
        Person save1 = new Person("3", "4", "EN", Sex.FEMALE);
        System.out.println(save.firstName+save.lastName+save.logger);
        System.out.println(save1.firstName+save1.lastName+save1.logger);
        outputStream.writeObject(save);
        outputStream.writeObject(save1);
        Person load = (Person)inputStream.readObject();
        Person load1 = (Person)inputStream.readObject();
        System.out.println(load.firstName+load.lastName+load.logger);
        System.out.println(load1.firstName+load1.lastName+load1.logger);
        inputStream.close();
        outputStream.close();
    }

}
