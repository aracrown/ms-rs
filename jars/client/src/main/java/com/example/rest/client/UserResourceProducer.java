package com.example.rest.client;

import com.example.rest.api.UserResource;
import org.aracrown.commons.rest.client.EndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by turisto on 21/11/2016.
 */
@Configuration
public class UserResourceProducer {

    @Autowired
    private EndpointConfig cfg;

    private UserResource userResource;

    UserResourceProducer(EndpointConfig cfg) {
        this.cfg = cfg;
    }

    public UserResource getUserResource() {
        if (userResource == null) {
            userResource = new JaxClientBuilder<>(UserResource.class).config(cfg).build();
        }
        return userResource;
    }
}
