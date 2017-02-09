package com.example.beans;

import com.example.rest.api.UserResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by turisto on 09/02/2017.
 */
@Named("userBean")
@RequestScoped
public class UserBean {

    @Inject
    private UserResource userResource;

    private String name = "name value";

    public String getName() {
        return userResource.retrieve("1").getUsername();
    }

    public void setName(String name) {
        this.name = name;
    }
}
