package com.javarush.test.level33.lesson05.home05;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,  property="className")
//@JsonSubTypes(@JsonSubTypes.Type(value=Auto.class, name=".Parking"))
public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}