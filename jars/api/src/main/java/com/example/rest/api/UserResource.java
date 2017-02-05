package com.example.rest.api;

import com.example.rest.api.model.User;
import com.example.rest.api.model.UserFilter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by turisto on 05/02/2017.
 */
@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface UserResource {
    @GET
    public Collection<User> get(@BeanParam UserFilter filter);

    @GET
    @Path("/{userId}/")
    User retrieve(@PathParam("userId") String userId);

    @POST
    String newUser(User request);

    @DELETE
    @Path("/{userId}/")
    public void delete(@PathParam("userId") String userId);

    @PUT
    @Path("/{userId}/")
    User update(@PathParam("userId") String userId, User request);
}
