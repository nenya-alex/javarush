package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Alex on 26.12.2014.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes type)
    {
        ImageReader a = null;

            if (type==ImageTypes.BMP)
                a = new BmpReader();
        else
            if (type==ImageTypes.JPG)
                a = new JpgReader();
        else
            if (type==ImageTypes.PNG)
                a = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

//        catch (IllegalArgumentException e)
//        {
//            System.out.println("Неизвестный тип картинки");
//        }
        return a;
    }




}
