package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by 4yu on 05.03.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes type)
    {
        ImageReader reader;
        if(type == ImageTypes.BMP)
            reader = new BmpReader();
        else if(type == ImageTypes.JPG)
            reader = new JpgReader();
        else if(type == ImageTypes.PNG)
            reader = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип");

        return reader;
    }
}
