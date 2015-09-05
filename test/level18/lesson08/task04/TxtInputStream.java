package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/
//так себе задача. Интересно что при обертке исключения в трай/кетч задача не принялась, а при пробрасывании исключения
// задача принята
public class TxtInputStream extends FileInputStream {
    String fileName;
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException
    {
        super(fileName);
        if (fileName.endsWith(".txt"))
        {
            this.fileName=fileName;
        }
        else
        {

                throw new UnsupportedFileNameException();

        }
    }

}

