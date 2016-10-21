package com.javarush.test.level21.lesson02.task01;

import org.jetbrains.annotations.Contract;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] arr = new byte[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = (byte) (ip[i] & mask[i]);
        }
        return arr;
    }

    public static void print(byte[] bytes) {
        String str = "";
        for(int i = 0; i < bytes.length; i++) {
            String bin = "";
            int j = 8;
            int k;
            if (bytes[i] >= 0)
                k = bytes[i];
            else
                k = 256 + bytes[i];
            while(k > 0) {
                if (k % 2 == 0)
                    bin += "0";
                else
                    bin += "1";
                k = k / 2;
                j--;
            }
            while(j > 0) {
                bin += "0";
                j--;
            }
            String rev = new StringBuilder(bin).reverse().toString();
            str = str + rev + " ";
        }
        System.out.println(str);
    }
}
