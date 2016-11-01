package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by mucherinovnv on 01.11.2016.
 */
public class Hippodrome
{
    public ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("horse1", 3, 0));
        game.getHorses().add(new Horse("horse2", 3, 0));
        game.getHorses().add(new Horse("horse3", 3, 0));
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void move() {
        ArrayList<Horse> h = getHorses();
        for (Horse horse : h) {
            horse.move();
        }
    }

    public void print() {
        ArrayList<Horse> h = getHorses();
        for (Horse horse : h) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double max = 0;
        ArrayList<Horse> h = getHorses();
        for (Horse horse : h) {
            if(horse.getDistance() > max)
            {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
