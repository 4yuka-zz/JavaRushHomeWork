package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String s = scanner.nextLine();
            String[] parts = s.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[5]), Integer.parseInt(parts[4]) - 1, Integer.parseInt(parts[3]));
            Date date = calendar.getTime();
            return new Person(parts[1], parts[2], parts[0], date);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }

}
