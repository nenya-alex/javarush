package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Admin on 20.07.15.
 */
public class UsersView implements View {

    private Controller controller;

//    public void fireEventOpenUserEditForm(long id) {
//        controller.onOpenUserEditForm(id);
//    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList() == true)
            System.out.println("All deleted users:");
        else
            System.out.println("All users:");
        for (User it: modelData.getUsers()) {
            System.out.println("\t" + it.toString());
        }
        System.out.println("===================================================");
    }


    public void fireEventShowDeletedUsers()
    {
        controller.onShowAllDeletedUsers();
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

}
