package com.example.rest.client;

import com.example.rest.api.UserResource;
import com.example.rest.api.model.User;
import com.example.rest.api.model.UserFilter;
import com.example.rest.client.com.example.rest.impl.EndpointConfig;
import com.example.rest.client.com.example.rest.impl.UserResourceProducer;

/**
 * Created by turisto on 05/02/2017.
 */
public class ClientApp {
    public static void main(String[] args) {

        EndpointConfig cfg = new EndpointConfig();
        cfg.endpoint("http://localhost:8080");
        UserResource ur = new UserResourceProducer(cfg).getUserResource();

        ur.newUser(new User("12345", "sample"));
        System.out.println(ur.retrieve("12345"));
        ur.update("12345", new User("12345", " sample2"));
        System.out.println(ur.retrieve("12345"));

        System.out.println(ur.get(new UserFilter()));
        ur.delete("12345");
        System.out.println(ur.get(new UserFilter()));
    }
}
