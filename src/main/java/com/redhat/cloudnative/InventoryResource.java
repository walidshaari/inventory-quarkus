package com.redhat.cloudnative;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/inventory")
@ApplicationScoped
public class InventoryResource {


    @GET
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Inventory getAvailability(@PathParam("itemId") long itemId) {
        return Inventory.findById(itemId);
    }


    @PUT
    @Transactional
    @Path("/{itemId}")
    public Inventory update(@PathParam("itemId") long itemId, Inventory i) {
        Inventory entity = Inventory.findById(itemId);
        if (entity == null) {
            throw new WebApplicationException("Item with id of " + itemId + " does not exist.", 404);
        }
        entity.quantity = i.quantity;
        return entity;
    }

}
