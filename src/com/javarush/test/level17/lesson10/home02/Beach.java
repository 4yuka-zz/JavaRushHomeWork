package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>
{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        int nameparam = this.name.compareTo(o.name);
        int distanceparam = (int) (this.distance - o.distance);
        int qualityparam = this.quality - o.quality;
        return 10000 * nameparam + 100 * distanceparam + qualityparam;

    }

/*    public static void main(String[] args)
    {
        Beach beach1 = new Beach("beach1", 123.6f, 7);
        Beach beach2 = new Beach("beach2", 124.6f, 8);
        Beach beach3 = new Beach("beach3", 124.6f, 8);
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach1.compareTo(beach3));
        System.out.println(beach2.compareTo(beach3));
    }*/
}
