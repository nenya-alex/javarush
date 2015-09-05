package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12.07.15.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop
{

    @XmlElementWrapper(name = "goods",nillable = true)
    public List<String> names = new ArrayList<>();
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement(name = "secretData",nillable = true)
    public List<String> secretData = new ArrayList<>();

    @Override
    public String toString() {
        return "Shop{" +
                "names=" + names +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}
