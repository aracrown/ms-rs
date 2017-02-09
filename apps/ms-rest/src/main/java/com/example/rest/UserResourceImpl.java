package com.example.rest;

import com.example.rest.api.UserResource;
import com.example.rest.api.model.User;
import com.example.rest.api.model.UserFilter;

import javax.inject.Named;
import javax.ws.rs.BeanParam;
import javax.ws.rs.PathParam;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vracelis on 2/2/17.
 */
@Named
public class UserResourceImpl implements UserResource {

    private static final Map<String, User> inMemoryUsers = new HashMap<>();

    @Override
    public Collection<User> get(@BeanParam UserFilter filter) {
        return inMemoryUsers.values();
    }

    @Override
    public User retrieve(@PathParam("userId") String userId) {
        User user = inMemoryUsers.get(userId);
        if (user == null) {
            user = new User();
            user.setUsername("DEMO USER");
        }
        return user;
    }

    @Override
    public String newUser(User request) {
        inMemoryUsers.put(request.getId(), request);
        return request.getId();
    }

    @Override
    public void delete(@PathParam("userId") String userId) {
        inMemoryUsers.remove(userId);
    }

    @Override
    public User update(@PathParam("userId") String userId, User request) {
        inMemoryUsers.put(userId, request);
        return request;
    }
}
