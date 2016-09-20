package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by x700 on 31.01.16.
 */
public class Singleton
{
    static Singleton e = null;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if(e == null)
            e = new Singleton();
        return e;
    }
}
