package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by x700 on 06.02.16.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
