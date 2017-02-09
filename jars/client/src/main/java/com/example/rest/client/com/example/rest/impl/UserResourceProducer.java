package com.example.rest.client.com.example.rest.impl;

import com.example.rest.api.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by turisto on 21/11/2016.
 */
@Configuration
public class UserResourceProducer {

    @Autowired
    private EndpointConfig cfg;

    private UserResource userResource;

    public UserResourceProducer(EndpointConfig cfg) {
        this.cfg = cfg;
    }

    @Bean
    public UserResource getUserResource() {
        if (userResource == null) {
            userResource = new JaxClientBuilder<>(UserResource.class).config(cfg).build();
        }
        return userResource;
    }
}
