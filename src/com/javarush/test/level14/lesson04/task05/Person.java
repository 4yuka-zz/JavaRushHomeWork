package com.javarush.test.level14.lesson04.task05;

/**
 * Created by mucherinovnv on 26.01.2016.
 */
public interface Person
{
    public static class User implements Person
    {
        public void live()
        {
            System.out.println("live");
        }
    }

    public static class Looser implements Person
    {
        public void doNothing()
        {
            System.out.println("doNothing");
        }
    }

    public static class Coder implements Person
    {
        public void coding()
        {
            System.out.println("coding");
        }
    }

    public static class Proger implements Person
    {
        public void enjoy()
        {
            System.out.println("enjoy");
        }
    }
}

