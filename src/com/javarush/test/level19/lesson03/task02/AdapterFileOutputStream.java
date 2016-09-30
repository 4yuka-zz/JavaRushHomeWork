package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{

    private FileOutputStream file;

    AdapterFileOutputStream (FileOutputStream file) {
        this.file = file;
    }

    @Override
    public void flush() throws IOException
    {
        file.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        char[] myCharArray = s.toCharArray();
        byte[] array = new String(myCharArray).getBytes();
        file.write(array);
    }

    @Override
    public void close() throws IOException
    {
        file.close();
    }
}

