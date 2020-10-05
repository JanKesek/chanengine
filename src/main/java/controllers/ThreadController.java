package controllers;

import models.Thread;
import services.ThreadService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@RequestScoped
public class ThreadController {
    //@Inject
    ThreadService threadService=new ThreadService();
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getThreadsByID(@PathParam("id") long id) {
        List<Thread> threads=threadService.getAllThreadsFromBoard(id);
        return Response.ok(threads).build();
    }
}
