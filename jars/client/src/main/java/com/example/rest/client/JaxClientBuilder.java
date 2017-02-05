package com.example.rest.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.aracrown.commons.http.HttpClientProducer;
import org.aracrown.commons.rest.ExceptionResolverInterceptor;
import org.aracrown.commons.rest.client.EndpointConfig;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.security.NoSuchAlgorithmException;

/**
 * Created by turisto on 21/11/2016.
 */
public class JaxClientBuilder<T> {
    /**
     * The logger instance.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JaxClientBuilder.class);

    private final Class<T> targetClass;

    private EndpointConfig cfg;

    private Client client;

    public JaxClientBuilder(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public JaxClientBuilder<T> config(EndpointConfig cfg) {
        this.cfg = cfg;
        return this;
    }

    public T build() {
        try {
            WebTarget target = newRestfulClient().target(cfg.getEndpoint());

            ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) target;
            resteasyWebTarget.register(ExceptionResolverInterceptor.class);
            return resteasyWebTarget.proxy(targetClass);
        } catch (Exception e) {
            LOGGER.error("Could not produce service for class {}", e);
        }
        return null;
    }

    protected Client newRestfulClient() throws NoSuchAlgorithmException {
        if (client == null) {
            ObjectMapper json = new ObjectMapper()
                    .findAndRegisterModules()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider(json);

            ResteasyClientBuilder builder = new ResteasyClientBuilder()
                    .httpEngine(new HttpClientProducer().getEngine())
                    .hostnameVerification(ResteasyClientBuilder.HostnameVerificationPolicy.ANY)
                    .register(jacksonJsonProvider);
            client = builder.build();
        }
        return client;
    }

}
