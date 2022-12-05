package gr.codehub.jakdb.resource;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.dto.OrderDto;
import gr.codehub.jakdb.service.ShopService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/shop")
public class ShopResource {

    @Inject
    private ShopService shopService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public String home() {
        return "This is a stakeholder";
    }

    @GET
    @Path("/customer")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CustomerDto> readAll() {
        return shopService.read();
    }

    @GET
    @Path("/customer/{customerId}")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto readOne(@PathParam("customerId") int customerId) {
        return shopService.read(customerId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/customer")
    @RolesAllowed("ADMIN")
    public CustomerDto insert(CustomerDto customer) {
        return shopService.create(customer);
    }


    @POST
    @Path("/order/{customerId}")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderDto createOrder(@PathParam("customerId") Long customerId){
        return shopService.createOrder(customerId);
    }




}