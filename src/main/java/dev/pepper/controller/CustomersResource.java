package dev.pepper.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import dev.pepper.model.Customer;
import dev.pepper.service.CustomersService;

@Path("server/customers")
public class CustomersResource {

    @Inject
    CustomersService service;

    @GET
    @Path("/rest/{multiplyer}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> list(@PathParam("multiplyer") int multiplyer) {
        return service.list(multiplyer);
    }

    @GET
    @Path("/rest/{id}/name")
    @Produces(MediaType.APPLICATION_JSON)
    public String findNameByid(@PathParam("id") Long id) {
        return service.find(id).name;
    }
}