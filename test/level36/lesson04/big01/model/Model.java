package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Admin on 20.07.15.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
}
