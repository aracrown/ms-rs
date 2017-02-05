package com.example.rest.client.com.example.rest.impl;

import javax.enterprise.inject.Vetoed;

/**
 * Created by turisto on 05/02/2017.
 */
@Vetoed
public class EndpointConfig {
    private String endpoint;

    private String apiKey;

    public EndpointConfig endpoint(String endpointUrl) {
        this.endpoint = endpointUrl;
        return this;
    }

    public EndpointConfig apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }
}