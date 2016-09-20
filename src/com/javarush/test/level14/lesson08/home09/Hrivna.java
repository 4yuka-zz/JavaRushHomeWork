package com.javarush.test.level14.lesson08.home09;

/**
 * Created by x700 on 30.01.16.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
