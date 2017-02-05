package com.example;

import com.example.rest.impl.UserResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * Created by vracelis on 2/2/17.
 */
@Named
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        packages(UserResourceImpl.class.getPackage().getName());
    }
}
